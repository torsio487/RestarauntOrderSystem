package com.restaurant.bridge;

public abstract class Order {
    protected PaymentProcessor paymentProcessor;
    protected final double baseAmount;

    public Order(PaymentProcessor paymentProcessor, double baseAmount) {
        if (paymentProcessor == null) {
            throw new IllegalArgumentException("Payment processor cannot be null.");
        }
        if (baseAmount <= 0) {
            throw new IllegalArgumentException("Base order amount must be greater than zero.");
        }
        this.paymentProcessor = paymentProcessor;
        this.baseAmount = baseAmount;
    }

    // Allows dynamic switching of the implementation at runtime
    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        if (paymentProcessor == null) {
            throw new IllegalArgumentException("Payment processor cannot be null.");
        }
        this.paymentProcessor = paymentProcessor;
    }

    public abstract double calculateTotal();
    public abstract void completeOrder();
}