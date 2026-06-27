package com.example.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.employeemanagementsystem.model.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // CREATE
    @PostMapping
    public Department createDepartment(
            @RequestBody Department department) {

        return departmentRepository.save(department);
    }

    // READ ALL
    @GetMapping
    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Department getDepartmentById(
            @PathVariable Long id) {

        return departmentRepository.findById(id)
                .orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Department updateDepartment(
            @PathVariable Long id,
            @RequestBody Department department) {

        Department existing =
                departmentRepository.findById(id)
                        .orElse(null);

        if (existing != null) {

            existing.setName(
                    department.getName());

            return departmentRepository.save(existing);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteDepartment(
            @PathVariable Long id) {

        departmentRepository.deleteById(id);

        return "Department Deleted Successfully";
    }
}