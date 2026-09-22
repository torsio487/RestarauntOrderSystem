package com.restaurant.factory;

public class SteakhouseRestaurant extends Restaurant {
    @Override
    public Meal createMeal() {
        return new SteakMeal();
    }

    @Override
    public Drink createDrink() {
        return new SteakComboDrink();
    }
}