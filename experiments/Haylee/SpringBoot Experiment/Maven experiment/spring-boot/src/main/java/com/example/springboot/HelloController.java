package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//restcontroller means that its ready to be used by spring mvc to handle web requests
@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        // returns text when called by curl
        // controller and responsebody are two annotations combined by restcontroller that return data to web requests rather than a view
        return "This is a message from my simple web controller :)";
    }

}

//hello controller creates a simple web application controller