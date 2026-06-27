package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(
            @PathVariable String email) {

        return employeeRepository.getEmployeeByEmail(
                email);
    }

    @GetMapping("/search/{keyword}")
    public List<Employee> searchEmployee(
            @PathVariable String keyword) {

        return employeeRepository.searchEmployees(
                keyword);
    }
}