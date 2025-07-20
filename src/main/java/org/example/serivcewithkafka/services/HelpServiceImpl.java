package org.example.serivcewithkafka.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.serivcewithkafka.dto.Compliment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HelpServiceImpl implements HelpService {
    private final Storage storage;

    @Override
    public void saveComplimentToStorage(Compliment compliment) {
        storage.addMessageToStorage(compliment);
    }

    @Override
    @SneakyThrows
    public Compliment getRandomComplimentFromStorage() {
        return storage.getRandomMessageFromStorage();
    }
}
