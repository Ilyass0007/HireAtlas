package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User loginUser) {
        User user = userRepository.findAll().stream()
            .filter(u -> u.getEmail().equals(loginUser.getEmail()) && u.getPassword().equals(loginUser.getPassword()))
            .findFirst()
            .orElse(null);

        if (user != null) {
            return "Login successful for user: " + user.getFullName();
        } else {
            return "Invalid email or password!";
        }
    }
}
