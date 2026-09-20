package com.restaurant.factory;

public class VeganMeal implements Meal {
    @Override
    public void prepare() {
        System.out.println("Preparing a vegan meal: Quinoa and roasted vegetables.");
    }

    @Override
    public void serve() {
        System.out.println("Serving the vegan meal in an eco-friendly bowl.");
    }
}