package org.example.serivcewithkafka.services;


import org.example.serivcewithkafka.dto.Compliment;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SetStorageImpl implements Storage {
    Set<Compliment> compliments = ConcurrentHashMap.newKeySet();

    @Override
    public void addMessageToStorage(Compliment message) {
        compliments.add(message);
    }

    @Override
    public Compliment getRandomMessageFromStorage() {
        return compliments.stream().findAny().orElseThrow();
    }

    public boolean notContains(Compliment compliment) {
        return !compliments.contains(compliment);
    }
}
