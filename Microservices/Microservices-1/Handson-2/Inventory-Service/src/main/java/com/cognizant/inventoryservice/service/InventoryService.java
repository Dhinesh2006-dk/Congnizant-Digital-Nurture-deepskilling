package com.cognizant.inventoryservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.inventoryservice.entity.Inventory;
import com.cognizant.inventoryservice.repository.InventoryRepository;
import com.cognizant.inventoryservice.dto.Product;
import com.cognizant.inventoryservice.feign.ProductClient;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    @Autowired
    private ProductClient productClient;

    public List<Inventory> getInventory() {
        return repository.findAll();
    }

    public Inventory save(Inventory inventory) {
        return repository.save(inventory);
    }

    public Product getProduct(Long id) {
        return productClient.getProduct(id);
    }

}

