package com.example.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeemanagementsystem.model.Department;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {

    Department findByName(String name);

    List<Department> findByNameContaining(
            String keyword);
}