package com.example.authservice.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean validateUser(String username, String password) {
        // Hardcoded user for now
        return "user".equals(username) && "pass".equals(password);
    }
}
