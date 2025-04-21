package com.example.demo.controllers;

import com.example.demo.dto.job.JobRequest;
import com.example.demo.dto.job.JobResponse;
import com.example.demo.services.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<JobResponse> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobResponse getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PostMapping
    public JobResponse createJob(@RequestBody @Valid JobRequest request) {
        return jobService.createJob(request);
    }

    @PutMapping("/{id}")
    public JobResponse updateJob(@PathVariable Long id, @RequestBody @Valid JobRequest request) {
        return jobService.updateJob(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
    }
}
