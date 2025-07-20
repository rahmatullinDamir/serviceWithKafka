package org.example.serivcewithkafka.controller;

import lombok.RequiredArgsConstructor;
import org.example.serivcewithkafka.dto.Compliment;
import org.example.serivcewithkafka.services.HelpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelpController {

    private final HelpService helpService;

    @GetMapping("/help-service/v1/support")
    public Compliment getRandomCompliment() {
            return helpService.getRandomComplimentFromStorage();
    }

    @PostMapping("/help-service/v1/support")
    public void saveComplimentToStorage(@RequestBody Compliment compliment) {
        helpService.saveComplimentToStorage(compliment);
    }

}
