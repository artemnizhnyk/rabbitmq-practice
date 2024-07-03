package com.artemnizhnyk.rabbitmqpractice.controller;

import com.artemnizhnyk.rabbitmqpractice.service.MessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/sender")
@RestController
public class MainController {

    private final MessageSender messageSender;

    @PostMapping("/send")
    ResponseEntity<?> send(@RequestBody final String message) {
        if (message.isBlank()) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        messageSender.send(message);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
