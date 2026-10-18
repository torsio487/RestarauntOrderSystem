package com.restaurant.facade;

public class PaymentGateway {
    // Process financial transaction
    public boolean processPayment(String accountId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid payment amount.");
        }
        System.out.println("[Payment] Charging $" + String.format("%.2f", amount) + " to account " + accountId);
        return true;
    }
}
