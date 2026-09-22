package com.restaurant.factory;

public class SteakComboDrink implements Drink {
    @Override
    public void serve() {
        System.out.println("Serving a glass of red wine.");
    }
}