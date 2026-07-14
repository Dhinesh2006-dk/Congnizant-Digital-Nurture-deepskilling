package com.cognizant.thirdpartyservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyController {

    @GetMapping("/thirdparty/payment")
    public String payment() throws Exception {

        System.out.println("Calling Third Party API...");
        System.out.println("Waiting 5 seconds...");
        Thread.sleep(5000);
        System.out.println("Payment Successful");
        return "Payment Successful";

    }

}
