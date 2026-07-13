package com.cognizant.productservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.productservice.entity.Product;
import com.cognizant.productservice.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product getProduct(Long id) {
        return repository.findById(id).orElse(null);
    }

}
