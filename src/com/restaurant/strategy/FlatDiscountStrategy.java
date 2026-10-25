package com.restaurant.strategy;

public class FlatDiscountStrategy implements DiscountStrategy {
    private final double discountAmount;

    public FlatDiscountStrategy(double discountAmount) {
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount cannot be negative.");
        }
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double originalTotal) {
        // Apply flat deduction, preventing negative totals
        return Math.max(0.0, originalTotal - discountAmount);
    }
}