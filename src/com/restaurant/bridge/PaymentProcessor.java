package com.restaurant.bridge;

public interface PaymentProcessor {
    void processPayment(double amount);
    String getPaymentType();
}
