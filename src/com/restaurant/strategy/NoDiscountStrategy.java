package com.restaurant.strategy;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double originalTotal) {
        // Return original price without reduction
        return originalTotal;
    }
}