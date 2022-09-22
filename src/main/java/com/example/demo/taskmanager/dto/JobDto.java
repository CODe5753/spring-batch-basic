package com.example.demo.taskmanager.dto;

import com.example.demo.taskmanager.entity.Job;
import com.example.demo.taskmanager.entity.JobLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobDto {

    String jobId;
    JobStatus status;
    String description;

    public JobDto(Job job) {
        jobId = job.getJobId();
        status = job.getStatus();
        description = job.getDescription();
    }

    public Job toJobEntity() {
        return Job.builder()
            .jobId(this.jobId)
            .status(this.status)
            .description(this.description)
            .build();
    }

    public JobLog toJobLogEntity(Job job) {
        return JobLog.builder()
            .job(job)
            .description(this.description)
            .status(this.status)
            .build();
    }
}
