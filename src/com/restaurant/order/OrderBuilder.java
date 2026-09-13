package com.restaurant.order;

public interface OrderBuilder {
    OrderBuilder setMainDish(String mainDish);
    OrderBuilder setSideDish(String sideDish);
    OrderBuilder setDrink(String drink);
    OrderBuilder setDessert(String dessert);
    OrderBuilder setTakeaway(boolean isTakeaway);
    Order build();
}