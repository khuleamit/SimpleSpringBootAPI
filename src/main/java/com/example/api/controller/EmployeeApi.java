package com.example.api.controller;

import com.example.api.entities.Employee;
import com.example.api.entities.Request;
import com.example.api.entities.Response;
import com.example.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import java.util.Optional;
import java.util.logging.Logger;


@RestController
public class EmployeeApi implements IEmployeeApi{

    @Autowired
    EmployeeService employeeService;

    private static final Logger LOGGER = Logger.getGlobal();

    @Override
    public ResponseEntity<Response> searchEmployeeByID(@Valid String id) {

        LOGGER.info("Searching Employee by ID  : " + id);

        Optional<Employee> employeeRecord = employeeService.getEmployeeByID(id);

        Response response = new Response();
        if (employeeRecord.isPresent()) {
            response.setEmployee(employeeRecord.get());
        } else {
            response.setApiMessage("Employee record not found");
            LOGGER.info("Employee record not found - ID  = " + id);
        }

        LOGGER.info("Api response returned : " + response);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> storeEmployeeRecord(@Valid Request request) {

        LOGGER.info("Api request received : " + request);
        Response response = new Response();
        response.setCorrelationId(request.getCorrelationId());
        Employee employee = request.getEmployee();

        if (employeeService.storeEmployee(employee)) {
            response.setApiMessage("Employee record stored successfully");
            response.setEmployee(employee);
            LOGGER.info("Api response returned : " + response);
            return ResponseEntity.ok(response);
        };

        response.setApiMessage("Failed to store Employee record");
        LOGGER.severe("Api response returned : " + response);
        return ResponseEntity.ok(response);

    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Response> notifyValidationError(Exception ex) {
        LOGGER.severe("Validation Exception  : " + ex.getMessage());
        Response response = new Response();
        response.setApiMessage(ex.getMessage());
        LOGGER.severe("Api response returned : " + response);
        return ResponseEntity.badRequest().body(response);

    }
}
