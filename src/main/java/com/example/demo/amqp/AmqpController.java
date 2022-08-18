package com.example.demo.amqp;

import com.example.demo.amqp.pojo.CustomMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AmqpController {

    private static final String EXCHANGE_NAME = "sample.exchange";

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/sample/queue")
    public String samplePublish() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "sample.code5753.#", CustomMessage.builder()
            .text("RabbitMQ + Spring!")
            .build());
        return "message sending!";
    }
}
