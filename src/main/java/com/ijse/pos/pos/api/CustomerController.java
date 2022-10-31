package com.ijse.pos.pos.api;

import com.ijse.pos.pos.dto.CustomerDto;
import com.ijse.pos.pos.service.CustomerService;
import com.ijse.pos.pos.service.impl.CustomerServiceImpl;
import com.ijse.pos.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveCustomer(
            @RequestBody CustomerDto dto
    ) {
        return new ResponseEntity<>(
                new StandardResponse(201,
                        customerService.saveCustomer(dto).getId()+"saved",
                        customerService.saveCustomer(dto)), HttpStatus.CREATED);
    }

    @PutMapping
    public String updateCustomer(
            @RequestBody CustomerDto dto
    ) {
        return customerService.updateCustomer(dto)+" Updated!";
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> getCustomer(
            @PathVariable String id
    ) {
        return new ResponseEntity<>(
                new StandardResponse(200,"Customer data",
                        customerService.getCustomer(id)), HttpStatus.OK
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteCustomer(
            @RequestParam String id
    ) {
        return new ResponseEntity<>(
                new StandardResponse(204, "Deleted",
                        customerService.deleteCustomer(id)),HttpStatus.OK
        );
    }

    @GetMapping("/list")
    public ResponseEntity<StandardResponse> getAllCustomer(
            @RequestParam(value = "page", defaultValue = "1", required = false) int page,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            @RequestParam(value = "searchText", defaultValue = "", required = false) String searchText
    ) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Customer List!",
                customerService.getAllCustomer(page, size, searchText)),HttpStatus.OK
        );
    }
}
