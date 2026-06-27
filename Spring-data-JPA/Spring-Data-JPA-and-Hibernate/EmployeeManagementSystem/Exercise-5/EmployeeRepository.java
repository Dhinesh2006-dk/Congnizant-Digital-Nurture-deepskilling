package com.example.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeemanagementsystem.model.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    // Derived Query Methods

    Employee findByEmail(String email);

    List<Employee> findByName(String name);

    List<Employee> findByNameContaining(String keyword);

    List<Employee> findByDepartmentName(String departmentName);

    // Custom Query using @Query

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee getEmployeeByEmail(
            @Param("email") String email);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:keyword%")
    List<Employee> searchEmployees(
            @Param("keyword") String keyword);

    // Named Query

    List<Employee> findByEmployeeName(
            @Param("name") String name);
}