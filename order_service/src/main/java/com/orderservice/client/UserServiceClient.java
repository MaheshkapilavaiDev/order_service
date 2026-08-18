package com.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

import com.orderservice.dto.UserResponse;
import com.orderservice.exception.UserServiceUnavailableException;

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

    	try {
        return restClient
                .get()
                .uri("/api/users/{id}", userId)
                .retrieve()
                .body(UserResponse.class);
    	}catch(HttpClientErrorException.NotFound ex) {
    		
    		throw new UserServiceUnavailableException(
                    "User was not found in User Service: "
                            + userId
            );
    	}catch(RestClientException ex) {
    		
    		throw new UserServiceUnavailableException(
                    "User Service is currently unavailable"
            );
    		
    	}
    }
}