package com.mrinal.otel.app1.controller;

import com.mrinal.otel.app1.db.respositories.OrderRepository;
import com.mrinal.otel.app1.kafka.KafkaReceiver;
import com.mrinal.otel.app1.kafka.KakfaSender;
import com.mrinal.otel.app1.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/a1")
public class RestServiceController {

    Logger logger = LoggerFactory.getLogger(RestServiceController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/ping")
    public String ping(){
        logger.info("In Ping");
        return "Hello,This is ping from service A1";
    }

    @GetMapping("/callA2")
    public String callA2(){
        logger.info("In call");
        String response = restTemplate.getForObject("http://localhost:8081/a2/serviceA2",String.class);

        logger.info("Response from application 2 is :  {}",response);
        return "Response from application 2 is :" + response ;
    }

    @GetMapping("/callA2AndSaveToDB")
    public String callA2AndSaveToDB(){
        logger.info("In call");
        String response = restTemplate.getForObject("http://localhost:8081/a2/serviceA2",String.class);
        orderRepository.save(new Order("Hardware",1,response));
        logger.info("Response from application 2 is :  {}",response);
        return "Response from application 2 is :" + response ;
    }


}
