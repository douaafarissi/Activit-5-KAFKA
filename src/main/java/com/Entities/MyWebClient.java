package com.Entities;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
@Component

public class MyWebClient {
    private final String BASE_URL = "https://example.com/api/";

    private final WebClient webClient;

    public MyWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://example.com/api/").build();
    }

    public MyEntity getEntityById(Long id) {
        return webClient.get()
                .uri("/entities/{id}", id)
                .retrieve()
                .bodyToMono(MyEntity.class)
                .block();
    }
}

