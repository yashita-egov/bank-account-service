package digit.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import digit.web.models.BankAccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.egov.tracer.kafka.CustomKafkaTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class Consumer {

    /*
    * Uncomment the below line to start consuming record from kafka.topics.consumer
    * Value of the variable kafka.topics.consumer should be overwritten in application.properties
    */
    //@KafkaListener(topics = {"kafka.topics.consumer"})
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private CustomKafkaTemplate<String, Object> kafkaTemplate;
//
//    @KafkaListener(topics = {"${bs.kafka.create.topic}"})
    public void listen(final HashMap<String, Object> record) {
//        try {
//
//            BankAccountRequest request = objectMapper.convertValue(record, BankAccountRequest.class);
//            log.info(request.toString());
//            kafkaTemplate.send(topic, value);
//        } catch (final Exception e) {
//
//            log.error("Error while listening to value: " + record + " on topic: " + topic + ": ", e);
//        }
    }
}
