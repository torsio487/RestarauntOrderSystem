package com.restaurant.visitor;

public class Beverage implements MenuItem {
    private String name;
    private double price;
    private boolean isAlcoholic;

    public Beverage(String name, double price, boolean isAlcoholic) {
        this.name = name;
        this.price = price;
        this.isAlcoholic = isAlcoholic;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isAlcoholic() { return isAlcoholic; }

    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visit(this); // Double dispatch step
    }
}
