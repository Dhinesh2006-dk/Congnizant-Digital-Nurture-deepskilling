package com.cognizant.customerservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.customerservice.entity.Customer;
import com.cognizant.customerservice.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.save(customer);
    }

}
