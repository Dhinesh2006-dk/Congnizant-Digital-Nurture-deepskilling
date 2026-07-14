package com.cognizant.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "thirdparty",
        url = "http://localhost:8081")
public interface ThirdPartyClient {

    @GetMapping("/thirdparty/payment")
    String processPayment();

}
