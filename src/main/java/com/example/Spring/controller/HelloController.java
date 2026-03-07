package com.example.Spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    //@PreAuthorize("hasRole('USER')")
    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PreAuthorize("hasAuthority('WEATHER_READ')")
    public String hello(){
        return "Welcome  Sunil Secure API";
    }
    @PutMapping("/world")
    @PreAuthorize("hasAuthority('WEATHER_READ')")
    public String world(){
        return "Welcome to SpringBoot";
    }

}