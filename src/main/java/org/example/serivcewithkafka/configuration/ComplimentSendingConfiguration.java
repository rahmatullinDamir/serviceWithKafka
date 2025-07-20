package org.example.serivcewithkafka.configuration;


import org.example.serivcewithkafka.dto.Compliment;
import org.example.serivcewithkafka.services.HelpService;
import org.example.serivcewithkafka.services.HelpServiceImpl;
import org.example.serivcewithkafka.services.KafkaNotificationHelpServiceImpl;
import org.example.serivcewithkafka.services.SetStorageImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.validation.annotation.Validated;
import org.example.serivcewithkafka.configuration.ComplimentSendingConfiguration.ComplimentSendingConfigurationProperties;


@Configuration
@ConditionalOnProperty(prefix = "application.support-phrase.kafka-sending", name = "enabled", havingValue = "true")
@EnableConfigurationProperties(ComplimentSendingConfigurationProperties.class)
public class ComplimentSendingConfiguration {

    @Bean
    @Primary
    public HelpService helpService(SetStorageImpl storage,
                                   KafkaTemplate<String, Compliment> kafka, ComplimentSendingConfigurationProperties properties) {
        return new KafkaNotificationHelpServiceImpl(
            kafka, storage, properties
        );
    }

    @Bean
    public ComplimentKafkaListener complimentKafkaListener(SetStorageImpl storage) {
        return new ComplimentKafkaListener(storage);
    }

    @Validated
    @ConfigurationProperties(prefix = "application.support-phrase.kafka-sending")
    public record ComplimentSendingConfigurationProperties (
            String topic,
            @NotNull Boolean enabled
    ){}

}
