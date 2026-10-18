package com.restaurant.facade;

public class RestaurantOrderFacade {
    private final InventoryStockChecker inventory;
    private final PaymentGateway payment;
    private final KitchenWorkflowManager kitchen;
    private final DeliveryDispatcher delivery;

    public RestaurantOrderFacade() {
        this.inventory = new InventoryStockChecker();
        this.payment = new PaymentGateway();
        this.kitchen = new KitchenWorkflowManager();
        this.delivery = new DeliveryDispatcher();
    }

    // Coordinate complete order workflow
    public void placeCompleteOrder(String dishName, double price, String accountId, int tableNumber, String address) {
        System.out.println("=== Starting Order Processing via Facade ===");

        // 1. Validate and update inventory
        if (!inventory.checkStock(dishName)) {
            throw new IllegalStateException("Item out of stock: " + dishName);
        }
        inventory.deductStock(dishName);

        // 2. Execute payment
        boolean paid = payment.processPayment(accountId, price);
        if (!paid) {
            throw new RuntimeException("Payment authorization failed.");
        }

        // 3. Trigger kitchen preparation
        kitchen.sendToKitchen(dishName, tableNumber);

        // 4. Arrange delivery
        delivery.dispatchOrder(dishName, address);

        System.out.println("=== Order Successfully Completed ===\n");
    }
}