package org.example.serivcewithkafka.services;


import org.example.serivcewithkafka.dto.Compliment;

public interface HelpService {
    void saveComplimentToStorage(Compliment compliment);
    Compliment getRandomComplimentFromStorage();
}
