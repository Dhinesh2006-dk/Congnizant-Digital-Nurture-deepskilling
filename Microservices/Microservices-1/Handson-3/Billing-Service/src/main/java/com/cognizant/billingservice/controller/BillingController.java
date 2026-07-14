package com.cognizant.billingservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.billingservice.entity.Billing;
import com.cognizant.billingservice.service.BillingService;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @Autowired
    private BillingService service;

    @GetMapping
    public List<Billing> getBills() {
        return service.getBills();
    }

    @PostMapping
    public Billing addBill(@RequestBody Billing billing) {
        return service.save(billing);
    }

}
