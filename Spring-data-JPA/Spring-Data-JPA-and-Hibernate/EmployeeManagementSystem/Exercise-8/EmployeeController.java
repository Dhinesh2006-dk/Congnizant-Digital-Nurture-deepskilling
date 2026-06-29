package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagementsystem.projection.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeView;
import com.example.employeemanagementsystem.repository.EmployeeRepository;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/projection")
    public List<EmployeeView> getProjection() {

        return employeeRepository.findBy();
    }

    @GetMapping("/dto")
    public List<EmployeeDTO> getDTOProjection() {

        return employeeRepository.getEmployeeDTOs();
    }
}