package com.example.springboottests;

import org.springframework.web.bind.annotation.*;


@RestController
class TestController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World! You just sent a GET request!";
    }

    @GetMapping("/welcome/{name}")
    public String welcome(@PathVariable String name) {
        return "Hello " + name + ", you're currently looking at my 309 Spring Boot Test!";
    }

    @PostMapping("/post")
    public String postName(@RequestParam(value = "name", defaultValue = "User") String name) {
        return String.format("Hey there " + name + "! You just send a POST request!");
    }


}

