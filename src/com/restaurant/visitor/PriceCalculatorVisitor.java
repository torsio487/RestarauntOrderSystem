package com.restaurant.visitor;

public class PriceCalculatorVisitor implements OrderVisitor {
    private double subtotal = 0.0;
    private double taxRate = 0.10; // 10% tax

    @Override
    public void visit(FoodDish foodDish) {
        subtotal += foodDish.getPrice();
    }

    @Override
    public void visit(Beverage beverage) {
        double price = beverage.getPrice();
        // Additional tax or surcharge for alcoholic beverages if needed
        if (beverage.isAlcoholic()) {
            price *= 1.05; // 5% extra sin tax
        }
        subtotal += price;
    }

    @Override
    public void visit(Dessert dessert) {
        subtotal += dessert.getPrice();
    }

    public double getTotalPrice() {
        return subtotal * (1 + taxRate);
    }

    public double getSubtotal() {
        return subtotal;
    }
}
