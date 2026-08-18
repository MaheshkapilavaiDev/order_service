package com.orderservice.entity;

public class Order {

    private Long orderId;
    private Long userId;
    private String product;
    private Double amount;

    public Order() {
    }

    public Order(Long orderId,
                 Long userId,
                 String product,
                 Double amount) {

        this.orderId = orderId;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getProduct() {
        return product;
    }

    public Double getAmount() {
        return amount;
    }
}
