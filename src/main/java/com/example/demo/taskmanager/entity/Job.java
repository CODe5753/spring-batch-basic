package com.example.demo.taskmanager.entity;

import com.example.demo.common.entity.BaseEntity;
import com.example.demo.taskmanager.dto.JobStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Job extends BaseEntity {

    @Id
    @Column(name = "job_id")
    String jobId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    JobStatus status;

    String description;
}
