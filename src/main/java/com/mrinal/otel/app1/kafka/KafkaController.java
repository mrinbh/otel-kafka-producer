package com.mrinal.otel.app1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;


@RestController
@RequestMapping("/a1")
public class KafkaController {


    @Autowired
    KakfaSender kakfaSender;

    @GetMapping("/send")
    public String send(){
        kakfaSender.send(UUID.randomUUID().toString());
        return "sent to Kafa ";
    }

    @GetMapping("/sendToKafka/{value}")
    public String sendToKafka(@PathVariable String value){
        kakfaSender.send(value);
        return "sent to Kafa with value : " + value;
    }
}
