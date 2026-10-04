package com.restaurant.bridge;

public class CashPayment implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount) + " in Cash at the register/courier.");
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}
