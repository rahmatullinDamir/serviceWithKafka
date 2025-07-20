package org.example.serivcewithkafka.configuration;


import lombok.RequiredArgsConstructor;
import org.example.serivcewithkafka.dto.Compliment;
import org.example.serivcewithkafka.services.SetStorageImpl;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class ComplimentKafkaListener {

    private final SetStorageImpl setStorage;

    @KafkaListener(topics = "${application.support-phrase.kafka-sending.topic}", groupId = "#{ T(java.util.UUID).randomUUID().toString() }")
    public void listen(Compliment compliment) {
        setStorage.addMessageToStorage(compliment);
    }


}
