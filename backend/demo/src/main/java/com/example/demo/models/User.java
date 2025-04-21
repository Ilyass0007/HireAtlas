package com.example.demo.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role; // "job_seeker", "employer", or "admin"

    // ——— NEW RELATIONSHIPS ———
    // If this User is an employer, list their jobs:
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Job> jobs;

    // If this User is a job seeker, list their applications:
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Application> applications;
    // ————————————————————————

    public User() {}

    public User(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ——— Getters & Setters ———

    public Long getId() { return id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public List<Job> getJobs() { return jobs; }
    public void setJobs(List<Job> jobs) { this.jobs = jobs; }

    public List<Application> getApplications() { return applications; }
    public void setApplications(List<Application> applications) { this.applications = applications; }
}
