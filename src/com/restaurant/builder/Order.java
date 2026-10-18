package com.restaraunt.builder;

public class Order {
    private final String mainDish;
    private final String sideDish;
    private final String drink;
    private final String dessert;
    private final boolean isTakeaway;

    Order(String mainDish, String sideDish, String drink, String dessert, boolean isTakeaway) {
        this.mainDish = mainDish;
        this.sideDish = sideDish;
        this.drink = drink;
        this.dessert = dessert;
        this.isTakeaway = isTakeaway;
    }

    @Override
    public String toString() {
        return "Order{" +
                "mainDish='" + mainDish + '\'' +
                ", sideDish='" + (sideDish != null ? sideDish : "None") + '\'' +
                ", drink='" + (drink != null ? drink : "None") + '\'' +
                ", dessert='" + (dessert != null ? dessert : "None") + '\'' +
                ", isTakeaway=" + isTakeaway +
                '}';
    }
}