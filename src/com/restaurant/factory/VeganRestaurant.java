package com.restaurant.factory;

public class VeganRestaurant extends Restaurant {
    @Override
    public Meal createMeal() {
        return new VeganMeal();
    }

    @Override
    public Drink createDrink() {
        return new VeganComboDrink();
    }
}