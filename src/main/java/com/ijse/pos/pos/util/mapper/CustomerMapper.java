package com.ijse.pos.pos.util.mapper;

import com.ijse.pos.pos.dto.CustomerDto;
import com.ijse.pos.pos.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {CustomerDto.class,Customer.class})
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
    Customer toCustomer(CustomerDto dto);
}
