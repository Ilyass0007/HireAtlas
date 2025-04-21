package com.example.demo.services;

import com.example.demo.dto.auth.LoginRequest;
import com.example.demo.dto.auth.RegisterRequest;
import com.example.demo.dto.auth.UserResponse;

public interface UserService {
    UserResponse register(RegisterRequest request);
    UserResponse login(LoginRequest request);
}
