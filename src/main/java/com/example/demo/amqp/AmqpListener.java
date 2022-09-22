package com.example.demo.amqp;

import com.example.demo.taskmanager.dto.JobDto;
import com.example.demo.taskmanager.service.TaskManagerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AmqpListener {

    private final TaskManagerService taskManagerService;

    @RabbitListener(queues = "sample.queue")
    public void receiveMessage(JobDto jobDto) {
        log.info("수신된 메세지 => id: {}, status: {}, message: {}", jobDto.getJobId(),
            jobDto.getStatus(), jobDto.getDescription());
        taskManagerService.updateJobStatus(jobDto);
    }
}
