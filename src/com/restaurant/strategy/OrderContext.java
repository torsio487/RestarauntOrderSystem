package com.restaurant.strategy;


public class OrderContext {
    private final String orderId;
    private final double rawTotal;
    private DiscountStrategy discountStrategy;

    public OrderContext(String orderId, double rawTotal, DiscountStrategy initialStrategy) {
        if (rawTotal < 0) {
            throw new IllegalArgumentException("Order total cannot be negative.");
        }
        if (initialStrategy == null) {
            throw new IllegalArgumentException("Discount strategy cannot be null.");
        }
        this.orderId = orderId;
        this.rawTotal = rawTotal;
        this.discountStrategy = initialStrategy;
    }

    // Change strategy at runtime
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        if (discountStrategy == null) {
            throw new IllegalArgumentException("Discount strategy cannot be null.");
        }
        this.discountStrategy = discountStrategy;
    }

    // Delegate calculation to current strategy
    public double calculateFinalTotal() {
        return discountStrategy.applyDiscount(rawTotal);
    }

    public void printSummary() {
        System.out.println("Order [" + orderId + "] | Raw: $" + String.format("%.2f", rawTotal)
                + " | Final: $" + String.format("%.2f", calculateFinalTotal()));
    }
}