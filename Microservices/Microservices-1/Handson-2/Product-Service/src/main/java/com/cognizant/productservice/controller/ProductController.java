package com.cognizant.productservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.productservice.entity.Product;
import com.cognizant.productservice.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return service.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

}
