package com.example.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagementsystem.model.Employee;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String keyword);
}