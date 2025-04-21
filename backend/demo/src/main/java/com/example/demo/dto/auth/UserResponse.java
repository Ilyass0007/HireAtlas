package com.example.demo.dto.auth;

public class UserResponse {

    private Long id;
    private String fullName;
    private String email;
    private String role;
    private String token;

    public UserResponse(Long id, String fullName, String email, String role, String token) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    // Getters only
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getToken() { return token; }
}
