package com.example.dashboardservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @GetMapping("/info")
    public Map<String,String> getInfo() {
        return Map.of("message","Welcome to your dashboard!");
    }
}