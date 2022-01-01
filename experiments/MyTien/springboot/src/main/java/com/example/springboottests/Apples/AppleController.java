package com.example.springboottests.Apples;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class AppleController {

    HashMap<String, Apple> apples = new  HashMap<>();

    @GetMapping("/apples")
    public @ResponseBody HashMap<String, Apple> getAllApples() {
        return apples;
    }

    @GetMapping("/new")
    public @ResponseBody String createPerson(@RequestParam String color,
                                             @RequestParam String type) {

        Apple apple = new Apple(color, type);
        apples.put(apple.getType(), apple);
        return "Apple created and saved!";
    }

    @GetMapping("/delete")
    public @ResponseBody HashMap<String, Apple> deletePerson(@RequestParam String type) {
        apples.remove(type);
        return apples;
    }
}
