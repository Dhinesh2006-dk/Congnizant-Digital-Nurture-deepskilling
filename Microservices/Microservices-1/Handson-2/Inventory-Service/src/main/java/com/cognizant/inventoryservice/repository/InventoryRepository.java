package com.cognizant.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.inventoryservice.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
