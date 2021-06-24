package com.example.api.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Request {

    private String correlationId;

    @NotNull(message = "Employee details are mandatory")
    private Employee employee;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Request{" +
                "correlationId='" + correlationId + '\'' +
                ", employee=" + employee +
                '}';
    }
}
