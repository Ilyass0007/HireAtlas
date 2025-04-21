package com.example.demo.services;

import com.example.demo.dto.application.ApplicationRequest;
import com.example.demo.dto.application.ApplicationResponse;

import java.util.List;

public interface ApplicationService {
    ApplicationResponse applyToJob(ApplicationRequest request, Long userId);
    List<ApplicationResponse> getApplicationsByUser(Long userId);
    List<ApplicationResponse> getApplicationsByJob(Long jobId);
}
