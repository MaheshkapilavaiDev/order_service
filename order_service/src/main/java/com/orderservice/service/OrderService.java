package com.orderservice.service;

import org.springframework.stereotype.Service;

import com.orderservice.client.UserServiceClient;
import com.orderservice.dto.OrderResponse;
import com.orderservice.dto.UserResponse;
import com.orderservice.entity.Order;

import java.util.Map;

@Service
public class OrderService {

    private final UserServiceClient userServiceClient;

    private final Map<Long, Order> orders = Map.of(
            1001L,
            new Order(
                    1001L,
                    1L,
                    "Laptop",
                    75000.0
            ),

            1002L,
            new Order(
                    1002L,
                    2L,
                    "Mobile",
                    30000.0
            )
    );

    public OrderService(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    public OrderResponse getOrderById(Long orderId) {

        Order order = orders.get(orderId);

        if (order == null) {
            throw new RuntimeException(
                    "Order not found with id: " + orderId
            );
        }

        UserResponse user =
                userServiceClient.getUserById(order.getUserId());

        return new OrderResponse(
                order.getOrderId(),
                order.getProduct(),
                order.getAmount(),
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
