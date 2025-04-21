package com.example.demo.controllers;

import com.example.demo.dto.auth.LoginRequest;
import com.example.demo.dto.auth.RegisterRequest;
import com.example.demo.dto.auth.UserResponse;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody @Valid RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }
}
