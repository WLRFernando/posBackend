package com.ijse.pos.pos.api;

import com.ijse.pos.pos.dto.CustomerDto;
import com.ijse.pos.pos.service.CustomerService;
import com.ijse.pos.pos.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String saveCustomer(
            @RequestBody CustomerDto dto
    ) {
        return customerService.saveCustomer(dto)+" Saved!";

    }

    @PutMapping
    public String updateCustomer(
            @RequestBody CustomerDto dto
    ) {
        return customerService.updateCustomer(dto)+" Updated!";
    }

    @GetMapping("/{id}")
    public String getCustomer(
            @PathVariable String id
    ) {
        return customerService.getCustomer(id);
    }

    @DeleteMapping
    public String deleteCustomer(
            @RequestParam String id
    ) {
        return "delete Customer";
    }

    @GetMapping
    public String getAllCustomer(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "searchText", defaultValue = "", required = false) String searchText
    ) {
        return customerService.getAllCustomer(page, size, searchText);
    }
}
