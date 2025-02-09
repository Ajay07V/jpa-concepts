package com.jpa_concepts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HealthCheck {

    @Autowired
    BuildProperties buildProperties;

    @GetMapping("/healthCheck")
    public Mono<String> index() {
        String jsonResponse = String.format("{\"artifact\": \"%s\", \"group\": \"%s\"}",
                buildProperties.getArtifact(),
                buildProperties.getGroup());
        return Mono.just(jsonResponse);
    }

}
