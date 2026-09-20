package com.restaraunt.builder;

public class OrderDirector {

    public Order constructStandardBurgerCombo(OrderBuilder builder) {
        return builder.setMainDish("Baconator")
                .setSideDish("Fries")
                .setDrink("Cola")
                .setTakeaway(true)
                .build();
    }

    public Order constructHealthyVeganMeal(OrderBuilder builder) {
        return builder.setMainDish("Caesar Salad")
                .setDrink("Smoothie")
                .setDessert("Fruit Bowl")
                .setTakeaway(false)
                .build();
    }
}