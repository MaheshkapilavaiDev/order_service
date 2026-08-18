package com.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.orderservice.dto.UserResponse;

@Component
public class UserServiceClient {

    private final RestClient restClient;

    public UserServiceClient(
            RestClient.Builder builder,
            @Value("${user-service.base-url}") String baseUrl) {

        this.restClient = builder
                .baseUrl(baseUrl)
                .build();
    }

    public UserResponse getUserById(Long userId) {

        return restClient
                .get()
                .uri("/api/users/{id}", userId)
                .retrieve()
                .body(UserResponse.class);
    }
}