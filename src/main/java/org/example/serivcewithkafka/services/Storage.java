package org.example.serivcewithkafka.services;

import org.example.serivcewithkafka.dto.Compliment;

public interface Storage {
    void addMessageToStorage(Compliment message);

    Compliment getRandomMessageFromStorage();

}
