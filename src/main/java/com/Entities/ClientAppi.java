package com.Entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication

public class ClientAppi {
    public static void main(String[] args) {
        SpringApplication.run(ClientAppi.class, args);
    }

    @Autowired
    private MyWebClient myWebClient;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            // Appel de votre service REST
            Long entityId = 1L;
            MyEntity entity = myWebClient.getEntityById(entityId);

            // Faites quelque chose avec l'entité récupérée
            System.out.println("Entity ID: " + entity.getId());
            System.out.println("Entity Name: " + entity.getName());
        };
    }
}
