//package org.example.serivcewithkafka.services;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.serivcewithkafka.dto.Compliment;
//import org.springframework.stereotype.Component;
//
//import java.util.*;
//
////@Component
//public class StorageImpl implements Storage {
//    private final Map<UUID, String> storage = new HashMap<>();
//    private Random random = new Random();
//
//    @Override
//    public void addMessageToStorage(Compliment message) {
//
//    }
//
//    @Override
//    public String getRandomMessageFromStorage() {
//        List<UUID> storageIdentifiers = storage.keySet().stream().toList();
//        return storage.get(storageIdentifiers.get(random.nextInt(storageIdentifiers.size())));
//    }
//}
