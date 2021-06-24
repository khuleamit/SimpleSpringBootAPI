package com.example.api.repositories;

import com.example.api.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class EmployeeRepo {

    private HashMap<String, Employee> EmployeeStore = new HashMap<>();

    public Optional<Employee> findEmployeeByID(String id)
    {

        if (EmployeeStore.containsKey(id)) {
            return Optional.ofNullable(EmployeeStore.get(id));
        }

        return Optional.empty();
    }

    public boolean storeEmployee(Employee employee)
    {
        if (EmployeeStore.containsKey(employee.getId())) {
            return false;
        }

        EmployeeStore.put(employee.getId(), employee);
        return true;
    }

}
