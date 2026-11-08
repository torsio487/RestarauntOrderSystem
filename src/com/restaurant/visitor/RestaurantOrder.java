package com.restaurant.visitor;

import java.util.ArrayList;
import java.util.List;

public class RestaurantOrder {
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    // Traverses the collection and invokes accept on each element
    public void accept(OrderVisitor visitor) {
        for (MenuItem item : items) {
            item.accept(visitor);
        }
    }
}
