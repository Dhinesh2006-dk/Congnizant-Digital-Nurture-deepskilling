package com.cognizant.inventoryservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.inventoryservice.dto.Product;

@FeignClient(name="product-service")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id);

}
