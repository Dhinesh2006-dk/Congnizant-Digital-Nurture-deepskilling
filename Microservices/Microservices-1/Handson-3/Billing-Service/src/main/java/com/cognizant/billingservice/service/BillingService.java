package com.cognizant.billingservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import com.cognizant.billingservice.entity.Billing;
import com.cognizant.billingservice.repository.BillingRepository;

@Service
public class BillingService {

    @Autowired
    private BillingRepository repository;

    @Cacheable("billing")
    public List<Billing> getBills() {
        return repository.findAll();
    }

    public Billing save(Billing billing) {
        return repository.save(billing);
    }

}
