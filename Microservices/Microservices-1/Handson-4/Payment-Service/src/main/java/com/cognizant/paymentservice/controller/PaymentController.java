package com.cognizant.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.paymentservice.service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping("/payment")
    public String payment() {

        return service.makePayment();

    }

}
