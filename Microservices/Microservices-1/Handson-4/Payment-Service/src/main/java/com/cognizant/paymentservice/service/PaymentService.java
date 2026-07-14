package com.cognizant.paymentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.paymentservice.client.ThirdPartyClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PaymentService {

    @Autowired
    private ThirdPartyClient client;

    @CircuitBreaker(
            name = "paymentService",
            fallbackMethod = "paymentFallback")
    public String makePayment() {

        System.out.println("Calling Third Party API...");
        String response = client.processPayment();
        System.out.println(response);
        return response;

    }

    public String paymentFallback(Exception ex) {

        System.out.println("================================");

        System.out.println("Circuit Breaker Triggered");

        System.out.println("Fallback Method Invoked");

        System.out.println("Reason : " + ex.getMessage());

        System.out.println("================================");

        return "Payment Service Temporarily Unavailable";

    }

}
