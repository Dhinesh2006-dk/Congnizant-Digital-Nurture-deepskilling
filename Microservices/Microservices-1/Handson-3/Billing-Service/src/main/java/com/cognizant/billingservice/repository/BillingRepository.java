package com.cognizant.billingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.billingservice.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
