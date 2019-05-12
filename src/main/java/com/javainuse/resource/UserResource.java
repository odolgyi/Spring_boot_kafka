package com.javainuse.resource;

import com.javainuse.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Service
@RequestMapping("/kafka/")
public class UserResource {

    @Value("message")
    private String kafkaTOPIC;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/producer/{name}")
    public void producerSendDataToKafka(@PathVariable("name") final String name) throws UnknownError {
        log.info("Data {} generated.", name);
        String userToString = new User(name, "09345", "Soborna").toString();
        kafkaTemplate.send(kafkaTOPIC, userToString);
    }
}