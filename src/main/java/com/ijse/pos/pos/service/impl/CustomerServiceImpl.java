package com.ijse.pos.pos.service.impl;

import com.ijse.pos.pos.dto.CustomerDto;
import com.ijse.pos.pos.dto.paginated.PaginatedResponseDto;
import com.ijse.pos.pos.entity.Customer;
import com.ijse.pos.pos.repo.CustomerRepo;
import com.ijse.pos.pos.service.CustomerService;
import com.ijse.pos.pos.util.mapper.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto dto) {
        customerRepo.save(
                new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary())
        );
        return dto;
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
        customerRepo.deleteById(id);
        return id+"Deleted!";
    }

    @Override
    public CustomerDto getCustomer(String id) {
        Optional<Customer> optional = customerRepo.findById(id);
        if(optional.isPresent()){
            return new CustomerDto(
                    optional.get().getId(),
                    optional.get().getName(),
                    optional.get().getAddress(),
                    optional.get().getSalary()
            );
        }
        return null;
    }

    @Override
    public PaginatedResponseDto getAllCustomer(int page, int size, String searchText) {
        List<Customer> all = customerRepo.findAll();
        List<CustomerDto> dtoList = new ArrayList<>();
        for (Customer c:all
             ) {
            dtoList.add(
                    new CustomerDto(c.getId(), c.getName(), c.getAddress(), c.getSalary())
            );
        }
        return
                new PaginatedResponseDto(
                        all.size(),
                        dtoList
                );
    }
}
