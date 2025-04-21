package com.example.demo.dto.application;

import jakarta.validation.constraints.NotNull;

public class ApplicationRequest {

    @NotNull
    private Long jobId;

    @NotNull
    private String cvPath;

    // Getters & Setters
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }
}
