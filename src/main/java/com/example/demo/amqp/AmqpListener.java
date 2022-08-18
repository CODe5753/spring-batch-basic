package com.example.demo.amqp;

import com.example.demo.amqp.pojo.CustomMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AmqpListener {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @RabbitListener(queues = "sample.queue")
    public void receiveMessage(CustomMessage message) {
        log.info("{}", message.getText());
    }
}
