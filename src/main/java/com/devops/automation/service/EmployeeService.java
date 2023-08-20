package com.devops.automation.service;

import com.devops.automation.model.Employee;
import com.devops.automation.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Optional<Employee> getEmployeeById(Long id) {

        return employeeRepo.findById(id);
    }

    public Employee addEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {

        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            employee.setId(employee.getId());
            employee.setFirstName(employee.getFirstName());
            employee.setLastName(employee.getLastName());
            employee.setEmail(employee.getEmail());
        }


        return employeeRepo.save(employee);
    }

}
