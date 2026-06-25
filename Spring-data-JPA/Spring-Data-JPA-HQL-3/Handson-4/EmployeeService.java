package com.cognizant.ormlearn.service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.ormlearn.repository.EmployeeRepository;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Transactional
    public double getAverageSalary(int departmentId) {
        return employeeRepository.getAverageSalary(departmentId);

    }
}