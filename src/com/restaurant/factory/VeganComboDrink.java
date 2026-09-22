package com.restaurant.factory;

public class VeganComboDrink implements Drink {
    @Override
    public void serve() {
        System.out.println("Serving a fresh green smoothie.");
    }
}