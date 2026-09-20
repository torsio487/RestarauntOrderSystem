package com.restaurant.factory;

public class VeganRestaurant extends Restaurant {
    @Override
    protected Meal createMeal() {
        return new VeganMeal();
    }
}