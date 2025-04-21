package com.example.demo.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    private String category;

    @Column(name = "experience_level")
    private String experienceLevel;

    @Column(name = "posted_at")
    private LocalDateTime postedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private User employer;

    // Constructors
    public Job() {}

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getExperienceLevel() { return experienceLevel; }

    public void setExperienceLevel(String experienceLevel) { this.experienceLevel = experienceLevel; }

    public LocalDateTime getPostedAt() { return postedAt; }

    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }

    public User getEmployer() { return employer; }

    public void setEmployer(User employer) { this.employer = employer; }
}
