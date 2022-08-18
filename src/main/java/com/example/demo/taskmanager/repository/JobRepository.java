package com.example.demo.taskmanager.repository;

import com.example.demo.taskmanager.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {

}
