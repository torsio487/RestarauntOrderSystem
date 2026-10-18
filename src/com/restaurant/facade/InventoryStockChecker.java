package com.restaurant.facade;

public class InventoryStockChecker {
    // Check ingredient stock availability
    public boolean checkStock(String dishName) {
        if (dishName == null || dishName.trim().isEmpty()) {
            return false;
        }
        System.out.println("[Inventory] Checking stock for: " + dishName);
        return true;
    }

    // Deduct items from storage
    public void deductStock(String dishName) {
        System.out.println("[Inventory] Deducting stock for: " + dishName);
    }
}