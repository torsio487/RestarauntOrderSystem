package com.restaurant.visitor;

public class PreparationTimeVisitor implements OrderVisitor {
    private int totalPrepTime = 0;

    @Override
    public void visit(FoodDish foodDish) {
        totalPrepTime += foodDish.getPreparationTimeMinutes();
    }

    @Override
    public void visit(Beverage beverages) {
        // Drinks take minimal prep time
        totalPrepTime += 2;
    }

    @Override
    public void visit(Dessert dessert) {
        // Desserts are prepared beforehand, take 1 minute to plate
        totalPrepTime += 1;
    }

    public int getTotalPreparationTime() {
        return totalPrepTime;
    }
}
