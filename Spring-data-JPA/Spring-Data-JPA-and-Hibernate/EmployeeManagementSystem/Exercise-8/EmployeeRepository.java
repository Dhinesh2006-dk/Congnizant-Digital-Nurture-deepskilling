package com.example.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.projection.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeView;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    // Interface Projection
    List<EmployeeView> findBy();

    // DTO Projection
    @Query("""
           SELECT new
           com.example.employeemanagementsystem.projection.EmployeeDTO
           (e.name, e.email)
           FROM Employee e
           """)
    List<EmployeeDTO> getEmployeeDTOs();
}