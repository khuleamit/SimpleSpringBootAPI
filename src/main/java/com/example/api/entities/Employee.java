package com.example.api.entities;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {


    @NotBlank(message = "Employee id is mandatory")
    private String id;

    @NotBlank(message = "Employee name is mandatory")
    private String name;

    @NotNull
    @NotBlank(message = "Employee dob is mandatory")
    private String dob;

    @NotBlank(message = "Employee SSN is mandatory")
    private String ssn;

    @NotBlank(message = "Employee email is mandatory")
    @Email(message = "Employee email format is incorrect")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob='" + dob.replaceAll("[0-9]", "X") + '\'' +
                ", ssn='" + ssn.replaceAll("[0-9]", "X") + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
