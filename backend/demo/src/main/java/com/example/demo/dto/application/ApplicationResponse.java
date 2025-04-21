package com.example.demo.dto.application;

import java.time.LocalDateTime;

public class ApplicationResponse {

    private Long id;
    private Long userId;
    private Long jobId;
    private String status;
    private String cvPath;
    private LocalDateTime appliedAt;

    public ApplicationResponse(Long id, Long userId, Long jobId, String status, String cvPath, LocalDateTime appliedAt) {
        this.id = id;
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
        this.cvPath = cvPath;
        this.appliedAt = appliedAt;
    }

    // Getters only
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public Long getJobId() { return jobId; }
    public String getStatus() { return status; }
    public String getCvPath() { return cvPath; }
    public LocalDateTime getAppliedAt() { return appliedAt; }
}
