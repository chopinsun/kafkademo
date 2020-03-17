package com.example.demo.bean;

import org.springframework.kafka.core.KafkaTemplate;

/**
 * @title: demo
 * @description:
 * @author: sunxiaobo
 * @create: 2020-03-17 16:39
 **/
public class KafkaSender {
    private KafkaTemplate<String, String> kafkaTemplate;
    public KafkaSender(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    /**
     * send message
     */
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
