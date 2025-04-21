package com.example.demo.services.impl;

import com.example.demo.dto.job.JobRequest;
import com.example.demo.dto.job.JobResponse;
import com.example.demo.models.Job;
import com.example.demo.models.User;
import com.example.demo.repositories.JobRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    private JobResponse toDto(Job job) {
        return new JobResponse(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getCategory(),
                job.getExperienceLevel(),
                job.getPostedAt(),
                job.getEmployer().getId(),
                job.getEmployer().getFullName()
        );
    }

    @Override
    public List<JobResponse> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public JobResponse getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
        return toDto(job);
    }

    @Override
    public JobResponse createJob(JobRequest request) {
        User employer = userRepository.findById(request.getEmployerId()).orElseThrow(() -> new RuntimeException("Employer not found"));

        Job job = new Job();
        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setCategory(request.getCategory());
        job.setExperienceLevel(request.getExperienceLevel());
        job.setEmployer(employer);
        job.setPostedAt(LocalDateTime.now());

        Job saved = jobRepository.save(job);
        return toDto(saved);
    }

    @Override
    public JobResponse updateJob(Long id, JobRequest request) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));

        job.setTitle(request.getTitle());
        job.setDescription(request.getDescription());
        job.setLocation(request.getLocation());
        job.setCategory(request.getCategory());
        job.setExperienceLevel(request.getExperienceLevel());

        Job updated = jobRepository.save(job);
        return toDto(updated);
    }

    @Override
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found");
        }
        jobRepository.deleteById(id);
    }
}
