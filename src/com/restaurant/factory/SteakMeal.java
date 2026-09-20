package com.restaurant.factory;

public class SteakMeal implements Meal {
    @Override
    public void prepare() {
        System.out.println("Grilling a premium T-bone steak to medium-rare.");
    }

    @Override
    public void serve() {
        System.out.println("Serving the steak on a hot cast-iron plate.");
    }
}