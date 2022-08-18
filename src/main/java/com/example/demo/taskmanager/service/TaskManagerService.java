package com.example.demo.taskmanager.service;

import com.example.demo.taskmanager.dto.JobDto;
import com.example.demo.taskmanager.dto.JobStatus;
import com.example.demo.taskmanager.entity.Job;
import com.example.demo.taskmanager.entity.JobLog;
import com.example.demo.taskmanager.repository.JobLogRepository;
import com.example.demo.taskmanager.repository.JobRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskManagerService {

    private final JobRepository jobRepository;
    private final JobLogRepository jobLogRepository;
    private final RabbitTemplate rabbitTemplate;

    public JobDto runJob(String provider, String description) {
        String uuid = UUID.randomUUID().toString();
        String status = JobStatus.READY.getStatus();

        JobDto job = JobDto.builder()
            .provider(provider)
            .jobId(uuid)
            .status(status)
            .description(description)
            .build();

        Job jobEntity = job.toJobEntity(uuid);
        JobLog jobLogEntity = job.toJobLogEntity(jobEntity);
        jobRepository.save(jobEntity);
        jobLogRepository.save(jobLogEntity);

        /* todo: rabbitTemplate을 이용한 이벤트 처리 */

        return job;
    }
}
