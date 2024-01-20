package com.Entities;

import org.springframework.web.client.RestTemplate;

public class MyRestClient {
    private final String BASE_URL = "https://example.com/api/";

    private final RestTemplate restTemplate;

    public MyRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MyEntity getEntityById(Long id) {
        String url = BASE_URL + "entities/" + id;
        return restTemplate.getForObject(url, MyEntity.class);
    }
}
