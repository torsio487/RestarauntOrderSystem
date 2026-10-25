package com.restaurant.strategy;

public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscountStrategy(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100.");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double originalTotal) {
        // Apply percentage reduction
        return originalTotal * (1.0 - (percentage / 100.0));
    }
}
