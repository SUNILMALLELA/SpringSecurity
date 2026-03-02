package com.example.Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Welcome  Sunil Secure API";
    }
    @PutMapping("/world")
    public String world(){
        return "Welcome to Java";
    }

}