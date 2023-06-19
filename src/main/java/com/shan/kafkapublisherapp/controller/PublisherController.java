package com.shan.kafkapublisherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PublisherController {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private String topic="topic1";

    @GetMapping("getMessage/{name}")
    public String getMessage(@PathVariable String name){
        kafkaTemplate.send(topic, "Hi "+name+", welcome to kafka world!");
        return "Data is published";
    }
}
