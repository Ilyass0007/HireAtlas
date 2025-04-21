package com.example.demo.dto.job;

import java.time.LocalDateTime;

public class JobResponse {

    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;
    private String experienceLevel;
    private LocalDateTime postedAt;
    private Long employerId;
    private String employerName;

    // Constructor
    public JobResponse(
        Long id,
        String title,
        String description,
        String location,
        String category,
        String experienceLevel,
        LocalDateTime postedAt,
        Long employerId,
        String employerName
    ) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.experienceLevel = experienceLevel;
        this.postedAt = postedAt;
        this.employerId = employerId;
        this.employerName = employerName;
    }

    // Getters only (you don't need setters for response objects)
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getLocation() { return location; }
    public String getCategory() { return category; }
    public String getExperienceLevel() { return experienceLevel; }
    public LocalDateTime getPostedAt() { return postedAt; }
    public Long getEmployerId() { return employerId; }
    public String getEmployerName() { return employerName; }
}
