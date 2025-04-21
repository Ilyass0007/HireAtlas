package com.example.demo.services.impl;

import com.example.demo.dto.application.ApplicationRequest;
import com.example.demo.dto.application.ApplicationResponse;
import com.example.demo.models.Application;
import com.example.demo.models.Job;
import com.example.demo.models.User;
import com.example.demo.repositories.ApplicationRepository;
import com.example.demo.repositories.JobRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    private ApplicationResponse toDto(Application application) {
        return new ApplicationResponse(
                application.getId(),
                application.getUser().getId(),
                application.getJob().getId(),
                application.getStatus(),
                application.getCvPath(),
                application.getAppliedAt()
        );
    }

    @Override
    public ApplicationResponse applyToJob(ApplicationRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Application application = new Application();
        application.setUser(user);
        application.setJob(job);
        application.setStatus("pending");
        application.setCvPath(request.getCvPath());
        application.setAppliedAt(LocalDateTime.now());

        Application saved = applicationRepository.save(application);
        return toDto(saved);
    }

    @Override
    public List<ApplicationResponse> getApplicationsByUser(Long userId) {
        return applicationRepository.findByUserId(userId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationResponse> getApplicationsByJob(Long jobId) {
        return applicationRepository.findByJobId(jobId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationResponse updateApplicationStatus(Long id, String status) {
        Application app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        app.setStatus(status);
        Application updated = applicationRepository.save(app);
        return toDto(updated);
    }
    @Override
    public void deleteApplication(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new RuntimeException("Application not found");
        }
        applicationRepository.deleteById(id);
    }
    @Override
    public ApplicationResponse getApplicationById(Long id) {
        var application = applicationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Application not found"));

        return new ApplicationResponse(
            application.getId(),
            application.getUser().getId(),
            application.getJob().getId(),
            application.getStatus(),
            application.getCvPath(),
            application.getAppliedAt()
        );
    }
    @Override
    public List<ApplicationResponse> getAllApplications() {
        return applicationRepository.findAll().stream()
            .map(application -> new ApplicationResponse(
                application.getId(),
                application.getUser().getId(),
                application.getJob().getId(),
                application.getStatus(),
                application.getCvPath(),
                application.getAppliedAt()
            ))
            .toList();
    }
    

}
