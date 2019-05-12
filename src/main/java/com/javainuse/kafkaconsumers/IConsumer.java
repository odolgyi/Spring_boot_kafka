package com.javainuse.kafkaconsumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface IConsumer {
    void consumeData(ConsumerRecord<String, String> userMessage);
}
