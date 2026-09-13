package com.restaurant.order;

public class RestarauntOrderBuilder implements OrderBuilder {
    private String mainDish;
    private String sideDish;
    private String drink;
    private String dessert;
    private boolean isTakeaway;

    @Override
    public OrderBuilder setMainDish(String mainDish) {
        this.mainDish = mainDish;
        return this; // chaining method
    }

    @Override
    public OrderBuilder setSideDish(String sideDish) {
        this.sideDish = sideDish;
        return this;
    }

    @Override
    public OrderBuilder setDrink(String drink) {
        this.drink = drink;
        return this;
    }

    @Override
    public OrderBuilder setDessert(String dessert) {
        this.dessert = dessert;
        return this;
    }

    @Override
    public OrderBuilder setTakeaway(boolean isTakeaway) {
        this.isTakeaway = isTakeaway;
        return this;
    }

    @Override
    public Order build() {
        // Validated construction: enforcing a required field
        if (mainDish == null || mainDish.trim().isEmpty()) {
            throw new IllegalStateException("Cannot build order: A main dish is required.");
        }
        return new Order(mainDish, sideDish, drink, dessert, isTakeaway);
    }
}