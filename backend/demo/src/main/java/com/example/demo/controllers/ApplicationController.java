package com.example.demo.controllers;

import com.example.demo.dto.application.ApplicationRequest;
import com.example.demo.dto.application.ApplicationResponse;
import com.example.demo.services.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Simulate user ID from auth (for now we'll hardcode it)
    private Long mockUserId = 2L; // Change as needed

    @PostMapping
    public ApplicationResponse applyToJob(@RequestBody @Valid ApplicationRequest request) {
        return applicationService.applyToJob(request, mockUserId);
    }

    @GetMapping("/user/{userId}")
    public List<ApplicationResponse> getByUser(@PathVariable Long userId) {
        return applicationService.getApplicationsByUser(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<ApplicationResponse> getByJob(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJob(jobId);
    }
}
