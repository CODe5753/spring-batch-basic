package com.example.demo.taskmanager.service;

import com.example.demo.taskmanager.dto.JobDto;
import com.example.demo.taskmanager.entity.Job;
import com.example.demo.taskmanager.entity.JobLog;
import com.example.demo.taskmanager.repository.JobLogRepository;
import com.example.demo.taskmanager.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskManagerService {

    private final JobRepository jobRepository;
    private final JobLogRepository jobLogRepository;

    public JobDto getJob(String jobId) {
        JobDto jobDto = new JobDto(jobRepository.findById(jobId).get());
        return jobDto;
    }

    @Transactional
    public void updateJobStatus(JobDto jobDto) {
        log.info("update => {}", jobDto.toString());

        Job job = jobDto.toJobEntity();
        jobRepository.save(job);

        JobLog jobLog = jobDto.toJobLogEntity(job);
        jobLogRepository.save(jobLog);

        log.info("update done!");
    }
}
