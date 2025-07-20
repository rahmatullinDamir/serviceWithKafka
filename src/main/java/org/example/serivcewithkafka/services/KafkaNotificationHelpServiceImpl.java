package org.example.serivcewithkafka.services;
import lombok.RequiredArgsConstructor;
import org.example.serivcewithkafka.configuration.ComplimentSendingConfiguration;
import org.example.serivcewithkafka.dto.Compliment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.example.serivcewithkafka.configuration.ComplimentSendingConfiguration.ComplimentSendingConfigurationProperties;

@RequiredArgsConstructor
public class KafkaNotificationHelpServiceImpl implements HelpService {

    private final KafkaTemplate<String, Compliment> kafkaTemplate;
    private final SetStorageImpl storage;
    private final  ComplimentSendingConfigurationProperties properties;

    @Override
    public void saveComplimentToStorage(Compliment compliment) {
        if (storage.notContains(compliment)) {
            kafkaTemplate.send(properties.topic(), compliment);
            storage.addMessageToStorage(compliment);
        }
    }

    @Override
    public Compliment getRandomComplimentFromStorage() {
        return storage.getRandomMessageFromStorage();
    }
}
