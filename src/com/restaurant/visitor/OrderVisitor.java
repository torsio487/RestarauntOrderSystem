package com.restaurant.visitor;

public interface OrderVisitor {
    void visit(FoodDish foodDish);
    void visit(Beverage beverage);
    void visit(Dessert dessert);
}