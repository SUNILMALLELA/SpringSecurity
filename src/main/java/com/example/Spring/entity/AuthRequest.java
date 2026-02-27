package com.example.Spring.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
