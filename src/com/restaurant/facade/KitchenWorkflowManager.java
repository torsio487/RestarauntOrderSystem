package com.restaurant.facade;

public class KitchenWorkflowManager {
    // Send order ticket to chefs
    public void sendToKitchen(String dishName, int tableNumber) {
        System.out.println("[Kitchen] Order sent to kitchen: " + dishName + " (Table #" + tableNumber + ")");
    }
}