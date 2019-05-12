package com.javainuse.kafkaconsumers;

import com.javainuse.Service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MessageConsumer implements IConsumer {

    @Autowired
    private MessageService messageService;

    @Override
    @KafkaListener(topics = "message", groupId = "message")
    public void consumeData(ConsumerRecord<String, String> userMessage) {
        log.info("Data {} consumed.", userMessage);
        System.out.println(splitStringToValues(userMessage.value()).toString());
        messageService.addUser(splitStringToValues(userMessage.value()));
    }

    public List<String> splitStringToValues(String inputtedString) {
        List<String> valuesList = new ArrayList<>();
        for (String word : inputtedString.split(" ")) {
            valuesList.add(word);
        }
        return valuesList;
    }
}
