package com.ijse.pos.pos.service.impl;

import com.ijse.pos.pos.dto.CustomerDto;
import com.ijse.pos.pos.entity.Customer;
import com.ijse.pos.pos.repo.CustomerRepo;
import com.ijse.pos.pos.service.CustomerService;
import com.ijse.pos.pos.util.mapper.CustomerMapper;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public String saveCustomer(CustomerDto dto) {
        return customerRepo.save(customerMapper.toCustomer(dto)).getName();
    }

    @Override
    public String updateCustomer(CustomerDto dto) {
        if(customerRepo.findById(dto.getId()).isPresent()) {
            return customerRepo.save(customerMapper.toCustomer(dto)).getName();
        }
        return dto.getId()+" id not found";
    }

    @Override
    public String deleteCustomer(String id) {
        return null;
    }

    @Override
    public String getCustomer(String id) {
        return customerMapper.toCustomerDto(customerRepo.findById(id).orElseThrow(()->new RuntimeException("Customer id not Found"))).toString();
    }

    @Override
    public String getAllCustomer(int page, int size, String searchText) {
        return customerRepo.findAll().stream().map(customer -> customerMapper.toCustomerDto(customer)).toString();
    }
}
