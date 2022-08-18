package com.example.demo.taskmanager.controller;

import com.example.demo.common.dto.ResponseDto;
import com.example.demo.taskmanager.service.TaskManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taskManager")
public class TaskManagerController {

    private final TaskManagerService taskManagerService;

    @PostMapping("/job")
    public ResponseDto<?> pushJob(@RequestBody String provider, @RequestBody String description) {
        var response = taskManagerService.runJob(provider, description);
        return ResponseDto.success(response);
    }
}
