package com.cognizant.inventoryservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.inventoryservice.entity.Inventory;
import com.cognizant.inventoryservice.service.InventoryService;
import com.cognizant.inventoryservice.dto.Product;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getInventory() {
        return service.getInventory();
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return service.save(inventory);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

}

