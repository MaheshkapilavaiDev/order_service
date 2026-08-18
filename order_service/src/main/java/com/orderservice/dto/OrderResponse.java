package com.orderservice.dto;

public class OrderResponse {

    private Long orderId;
    private String product;
    private Double amount;

    private Long userId;
    private String userName;
    private String userEmail;

    public OrderResponse(
            Long orderId,
            String product,
            Double amount,
            Long userId,
            String userName,
            String userEmail) {

        this.orderId = orderId;
        this.product = product;
        this.amount = amount;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public Double getAmount() {
        return amount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
