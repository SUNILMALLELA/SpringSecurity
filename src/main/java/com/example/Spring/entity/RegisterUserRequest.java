package com.example.Spring.entity;


import lombok.Data;
@Data
public class RegisterUserRequest {
    private String username;
    private String password;
    private Role role;
}
