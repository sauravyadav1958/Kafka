package com.dailycodebuffer.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String,Book> kafkaTemplate;
    // topic to which data will be published
    // TOPIC will get automatically created in config if not defined already.
    private static final String TOPIC = "NewTopic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book) throws InterruptedException {
        kafkaTemplate.send(TOPIC, book);
//        int range = 100;
//        while (range > 0) {
//            kafkaTemplate.send(TOPIC, book);
//         // Pause the current thread for 1000 millisecond
//            Thread.sleep(1000);
//            range --;
//        }
        return "Published Successfully!";
    }
}
