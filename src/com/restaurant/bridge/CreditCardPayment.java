package com.restaurant.bridge;

public class CreditCardPayment implements PaymentProcessor {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be empty.");
        }
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Paid $" + String.format("%.2f", amount) + " using Credit Card [" + maskCardNumber(cardNumber) + "].");
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }

    private String maskCardNumber(String card) {
        if (card.length() < 4) return "****";
        return "****-****-****-" + card.substring(card.length() - 4);
    }
}