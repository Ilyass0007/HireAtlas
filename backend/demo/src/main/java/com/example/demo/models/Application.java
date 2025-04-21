package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many applications ← 1 user (job seeker)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Many applications ← 1 job
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "cv_path")
    private String cvPath;

    private String status;   // e.g. "pending", "reviewed", "interview", "rejected"

    @Column(name = "applied_at")
    private LocalDateTime appliedAt = LocalDateTime.now();

    // Constructors
    public Application() {}

    // Getters & setters
    public Long getId() { return id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }

    public String getCvPath() { return cvPath; }
    public void setCvPath(String cvPath) { this.cvPath = cvPath; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getAppliedAt() { return appliedAt; }
    public void setAppliedAt(LocalDateTime appliedAt) { this.appliedAt = appliedAt; }
}
