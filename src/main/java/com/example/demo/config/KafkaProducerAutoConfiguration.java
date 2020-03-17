package com.example.demo.config;

import com.example.demo.bean.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @title: jdcloud-audit-trail
 * @description:
 * @author: sunxiaobo
 * @create: 2020-03-17 11:37
 **/
@Configuration
public class KafkaProducerAutoConfiguration {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Bean
    public KafkaSender kafkaSender(){
        return new KafkaSender(kafkaTemplate);
    }

}
