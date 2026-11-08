package com.restaurant.visitor;

public interface MenuItem {
    // Accepts a visitor for double-dispatch
    void accept(OrderVisitor visitor);
}
