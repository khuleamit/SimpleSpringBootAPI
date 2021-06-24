package com.example.api.controller;

import com.example.api.entities.Request;
import com.example.api.entities.Response;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Api(value = "employee")
@RequestMapping(value = "/employee")
@Validated
public interface IEmployeeApi {


    @ApiOperation(value = "search an employee record", nickname = "employee", notes = "Employee REST API", response = Response.class, responseContainer = "List", tags={ "general", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful", response = Response.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Response> searchEmployeeByID(@ApiParam(value = "employee id"  )  @Valid @PathVariable String id);


    @ApiOperation(value = "store an employee record", nickname = "employee", notes = "Employee REST API", response = Response.class, responseContainer = "List", tags={ "general", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful", response = Response.class, responseContainer = "List"),
            @ApiResponse(code = 201, message = "item created"),
            @ApiResponse(code = 400, message = "invalid input, object invalid"),
            @ApiResponse(code = 409, message = "an existing item already exists") })
    @RequestMapping(value = "/",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Response> storeEmployeeRecord(@ApiParam(value = "employee record"  )  @Valid @RequestBody Request request);


}
