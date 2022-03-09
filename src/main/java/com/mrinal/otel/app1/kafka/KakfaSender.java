package com.mrinal.otel.app1.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.websocket.SendResult;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class KakfaSender {

   Logger logger = LoggerFactory.getLogger(KakfaSender.class);

    @Autowired
    KafkaTemplate kafkaTemplate;

  /*  @Autowired
    Tracer tracer;

    @Autowired
    Propagator propagator;*/

    private String topic="mr-topic-1";


    public void send(String value){
        logger.info("Sending to kafka ");
        String start = ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
        //Object values = Arrays.asList(value.getBytes(),("2ndValueOf" +value).getBytes(),("3rdValueOf" + value).getBytes()).;
        ProducerRecord record= new ProducerRecord(topic,value);
        record.headers().add("someHead","someHeadVal".getBytes());
        kafkaTemplate.send(record);
        logger.info("Sent Record with value :{}",value);
    }


}
