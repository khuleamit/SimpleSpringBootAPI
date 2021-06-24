package com.example.api.controller;

import com.example.api.entities.Employee;
import com.example.api.entities.Request;
import com.example.api.entities.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;


@SpringBootTest
class EmployeeApiTest {


    @Autowired
    private EmployeeApi employeeApi;


    @Test
    void storeEmployeeRecordValid() {
        Request request = new Request();
        request.setCorrelationId("UnitTest#1");
        request.setEmployee(getValidEmployee());
        ResponseEntity<Response> response = employeeApi.storeEmployeeRecord(request);
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "API Status expected was OK");
    }

    //Need to check why @ExceptionHandler is not working in Test mode
/*    @Test
    void storeEmployeeRecordInValid() {
        Request request = new Request();
        request.setCorrelationId("UnitTest#2");
        request.setEmployee(getInValidEmployee());
        ResponseEntity<Response> response = employeeApi.storeEmployeeRecord(request);
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.BAD_REQUEST), "API Status expected was BAD_REQUEST");
    }*/


    @Test
    void searchEmployeeByIDValid() {
        Employee employee = getValidEmployee();
        ResponseEntity<Response> response = employeeApi.searchEmployeeByID(employee.getId());
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "API Status expected was OK");

    }

    @Test
    void searchEmployeeByIDInValid() {
        Employee employee = getInValidEmployee();
        ResponseEntity<Response> response = employeeApi.searchEmployeeByID(employee.getId());
        Assert.isTrue(response.getStatusCode().equals(HttpStatus.OK), "API Status expected was OK");
        Assert.isTrue(response.hasBody(), "Response body was expected");
        Assert.isTrue(response.getBody().getApiMessage().equals("Employee record not found"), "Expected message = Employee record not found");
    }

    private Employee getValidEmployee() {
        Employee employee = new Employee();
        employee.setId("1");
        employee.setName("EName");
        employee.setDob("2010-01-01");
        employee.setEmail("test@test.com");
        employee.setSsn("123-45-6789");
        return employee;
    }

    private Employee getInValidEmployee() {
        Employee employee = new Employee();
        employee.setId("2");
        employee.setDob("2010-01-01");
        employee.setEmail("test@test.com");
        employee.setSsn("123-45-6789");
        return employee;
    }
}