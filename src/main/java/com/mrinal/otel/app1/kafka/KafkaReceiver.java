package com.mrinal.otel.app1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;

import java.util.Map;

public class KafkaReceiver {

     @Value("${kakfa.topic.1}")
     String topic1;

    Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);


    @KafkaListener(topics = "mr-topic-2")
    public void receiveFromTopic(String val, @Headers Map<String,Object> headers){
       logger.info("Inside  Kafka receiver from mr-topic-2 ");
       headers.forEach((key,value) ->logger.info("key is: {} ,value is {}",key,value));
       logger.info("received value {} from mr-topic-2 ",val);
    }
}
