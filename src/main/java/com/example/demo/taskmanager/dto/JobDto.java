package com.example.demo.taskmanager.dto;

import com.example.demo.taskmanager.entity.Job;
import com.example.demo.taskmanager.entity.JobLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobDto {

    String provider;
    String jobId;
    String status;
    String description;

    public Job toJobEntity(String jobId) {
        this.jobId = jobId;
        return Job.builder()
            .jobId(this.jobId)
            .provider(this.provider)
            .status(this.status)
            .description(this.description)
            .build();
    }

    public JobLog toJobLogEntity(Job job) {
        return JobLog.builder()
            .job(job)
            .description(this.description)
            .status(this.status)
            .provider(this.provider)
            .build();
    }
}
