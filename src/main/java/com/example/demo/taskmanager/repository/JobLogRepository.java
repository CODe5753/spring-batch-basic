package com.example.demo.taskmanager.repository;

import com.example.demo.taskmanager.entity.JobLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobLogRepository extends JpaRepository<JobLog, Long> {

}
