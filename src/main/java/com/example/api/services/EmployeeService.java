package com.example.api.services;

import com.example.api.entities.Employee;
import com.example.api.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Service
@Validated
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public Optional<Employee> getEmployeeByID(String id)
    {
        return employeeRepo.findEmployeeByID(id);
    }

    public boolean storeEmployee(@Valid Employee employee)
    {
        return employeeRepo.storeEmployee(employee);
    }


}
