package com.restaurant.factory;

public class SteakhouseRestaurant extends Restaurant {
    @Override
    protected Meal createMeal() {
        return new SteakMeal();
    }
}