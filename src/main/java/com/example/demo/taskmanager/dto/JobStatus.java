package com.example.demo.taskmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JobStatus {
    READY("READY"), RUNNING("RUNNING"), DONE("DONE"), FAILURE("FAILURE");

    private final String status;
}
