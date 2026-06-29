package com.example.employeemanagementsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.employeemanagementsystem.model.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(
                EmployeeManagementSystemApplication.class,
                args);

        System.out.println(
                "Hibernate Features Implemented Successfully");
    }

    @Bean
    CommandLineRunner run(
            EmployeeService employeeService) {

        return args -> {

            List<Employee> employees =
                    new ArrayList<>();

            employees.add(
                    new Employee(null,
                            "Dhinesh",
                            "dhinesh@gmail.com"));

            employees.add(
                    new Employee(null,
                            "Kumar",
                            "kumar@gmail.com"));

            employees.add(
                    new Employee(null,
                            "John",
                            "john@gmail.com"));

            employeeService.saveEmployees(
                    employees);
        };
    }
}