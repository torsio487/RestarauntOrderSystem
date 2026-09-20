package com.restaraunt.builder;

public class Main {
    public static void main(String[] args) {
        OrderDirector director = new OrderDirector();

        // director use
        System.out.println("--- Building predefined meals using Director ---");
        Order burgerCombo = director.constructStandardBurgerCombo(new RestarauntOrderBuilder());
        System.out.println("Burger Combo: " + burgerCombo);

        Order veganMeal = director.constructHealthyVeganMeal(new RestarauntOrderBuilder());
        System.out.println("Vegan Meal: " + veganMeal);

        // builder use
        System.out.println("\n--- Building a custom meal using Fluent Builder ---");
        Order customOrder = new RestarauntOrderBuilder()
                .setMainDish("Grilled Steak")
                .setSideDish("Mashed Potatoes")
                .setTakeaway(false)
                .build();
        System.out.println("Custom Order: " + customOrder);

        // test
        System.out.println("\n--- Testing Exception for invalid state ---");
        try {
            Order invalidOrder = new RestarauntOrderBuilder()
                    .setDrink("Water")
                    .build(); // Missing main dish
        } catch (IllegalStateException e) {
            System.out.println("Exception caught successfully: " + e.getMessage());
        }
    }
}