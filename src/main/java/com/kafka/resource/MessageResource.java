package com.kafka.resource;

import com.kafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/kafka")
@RestController
public class MessageResource {

    private KafkaProducer kafkaProducer;

    public MessageResource(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    //http:localhost:8080/api/v1/kafka/publish?message=hello anix001
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
      kafkaProducer.sendMessage(message);
      return ResponseEntity.ok("Message sent to the Topic");
    }
}
