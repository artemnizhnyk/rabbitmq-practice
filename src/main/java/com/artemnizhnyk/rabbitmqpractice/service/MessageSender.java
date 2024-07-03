package com.artemnizhnyk.rabbitmqpractice.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Setter
@RequiredArgsConstructor
@Service
public class MessageSender {

    private final AmqpTemplate amqpTemplate;
    @Value("${queue.name}")
    private String queueName;

    public void send(final String message) {
        amqpTemplate.convertAndSend(queueName, message);
    }
}
