package com.restaurant.factory;

public abstract class Restaurant {

    // factory method
    public Meal orderMeal() {
        System.out.println("--- New Order Received ---");
        Meal meal = createMeal();
        meal.prepare();
        meal.serve();
        return meal;
    }

    // also factory method
    protected abstract Meal createMeal();
}