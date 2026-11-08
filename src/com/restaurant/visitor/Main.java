package com.restaurant.visitor;

public class Main {
    public static void main(String[] args) {
        RestaurantOrder order = new RestaurantOrder();
        order.addItem(new FoodDish("T-bone Steak", 25.00, 20));
        order.addItem(new Beverage("Dark Beer", 6.50, true));
        order.addItem(new Dessert("Cheesecake", 8.00, 450));

        // 1. Calculate price and taxes
        PriceCalculatorVisitor priceVisitor = new PriceCalculatorVisitor();
        order.accept(priceVisitor);
        System.out.println("Subtotal: $" + String.format("%.2f", priceVisitor.getSubtotal()));
        System.out.println("Total Price (with tax): $" + String.format("%.2f", priceVisitor.getTotalPrice()));

        // 2. Calculate preparation time
        PreparationTimeVisitor timeVisitor = new PreparationTimeVisitor();
        order.accept(timeVisitor);
        System.out.println("Total Estimated Preparation Time: " + timeVisitor.getTotalPreparationTime() + " minutes");
    }
}
