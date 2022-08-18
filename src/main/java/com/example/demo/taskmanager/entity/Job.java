package com.example.demo.taskmanager.entity;

import com.example.demo.common.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job extends BaseEntity {

    @Id
    @Column(name = "job_id")
    String jobId;

    String status;

    String description;

    String provider;
}
