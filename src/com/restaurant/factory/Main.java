package com.restaurant.factory;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Vegan Order ---");
        Restaurant veganFactory = new VeganRestaurant();
        Meal veganMeal = veganFactory.createMeal();
        Drink veganDrink = veganFactory.createDrink();

        veganMeal.prepare();
        veganMeal.serve();
        veganDrink.serve();

        System.out.println("\n--- Steakhouse Order ---");
        Restaurant steakFactory = new SteakhouseRestaurant();
        Meal steakMeal = steakFactory.createMeal();
        Drink steakDrink = steakFactory.createDrink();

        steakMeal.prepare();
        steakMeal.serve();
        steakDrink.serve();
    }
}