package com.restaurant.visitor;

public class FoodDish implements MenuItem {
    private String name;
    private double price;
    private int preparationTimeMinutes;

    public FoodDish(String name, double price, int preparationTimeMinutes) {
        this.name = name;
        this.price = price;
        this.preparationTimeMinutes = preparationTimeMinutes;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getPreparationTimeMinutes() { return preparationTimeMinutes; }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this); // Double dispatch step
    }
}
