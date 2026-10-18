package com.restaurant.facade;

public class DeliveryDispatcher {
    // Dispatch courier for delivery
    public void dispatchOrder(String dishName, String deliveryAddress) {
        System.out.println("[Delivery] Dispatched '" + dishName + "' to address: " + deliveryAddress);
    }
}