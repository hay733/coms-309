package com.cs309.scout.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test Controller for Remote and Local Server
 */
@Api(value = "HelloTestController", description = "Controller to help test if server is working")
@RestController
public class Hello {

    /**
     * Returns a string test
     * @return string
     */
    @ApiOperation(value = "Test Endpoint for Server", response = Hello.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/")
    public String index() {
        return "Greetings, Scout Spring Boot is working!!";
    }

}