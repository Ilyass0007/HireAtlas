package com.example.demo.repositories;

import com.example.demo.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    // Optional helper method to fetch jobs by employer
    List<Job> findByEmployerId(Long employerId);
}
