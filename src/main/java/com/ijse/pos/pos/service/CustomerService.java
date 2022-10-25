package com.ijse.pos.pos.service;

import com.ijse.pos.pos.dto.CustomerDto;

public interface CustomerService {
    public String saveCustomer(CustomerDto dto);
    public String updateCustomer(CustomerDto dto);
    public String deleteCustomer(String id);
    public String getCustomer(String id);
    public String getAllCustomer(int page, int size, String searchText);
}
