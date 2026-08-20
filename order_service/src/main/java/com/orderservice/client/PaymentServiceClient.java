package com.orderservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import io.github.resilience4j.retry.annotation.Retry;

@Component
public class PaymentServiceClient {

    private final RestClient restClient;

    public PaymentServiceClient(
            RestClient.Builder builder,
            @Value("${payment-service.base-url}") String baseUrl) {

        this.restClient = builder
                .baseUrl(baseUrl)
                .build();
    }

    @Retry(name = "paymentService")
    public String processPayment(Long orderId) {

    	try {
        return restClient
                .get()
                .uri("/api/payments/{orderId}", orderId)
                .retrieve()
                .body(String.class);
    	}catch (Exception e) {

            System.out.println(
                    "Payment Service call failed: " + e.getMessage()
            );

            throw e;
        }
    }
}
