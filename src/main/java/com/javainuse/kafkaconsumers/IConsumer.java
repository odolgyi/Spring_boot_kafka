package com.javainuse.kafkaconsumers;

import com.javainuse.Entity.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IConsumer {
    void consumeData(ConsumerRecord<String, String> userMessage);
}
