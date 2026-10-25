package com.restaurant.strategy;

public interface DiscountStrategy {
    // Apply discount algorithm to order total
    double applyDiscount(double originalTotal);
}
