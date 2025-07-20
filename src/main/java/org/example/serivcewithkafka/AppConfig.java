package org.example.serivcewithkafka;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration(exclude = KafkaAutoConfiguration.class)
@ConditionalOnProperty(prefix = "application.support-phrase.kafka-sending", name = "enabled", havingValue = "false")
public class AppConfig {
}
