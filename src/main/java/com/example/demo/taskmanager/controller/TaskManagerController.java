package com.example.demo.taskmanager.controller;

import com.example.demo.common.dto.ResponseDto;
import com.example.demo.taskmanager.dto.JobDto;
import com.example.demo.taskmanager.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskManager")
public class TaskManagerController {

    private final TaskManagerService taskManagerService;

    @GetMapping("/job")
    public ResponseDto<?> getJobStatus(@RequestParam String jobId) {
        var response = taskManagerService.getJob(jobId);
        return ResponseDto.success(response);
    }
}
