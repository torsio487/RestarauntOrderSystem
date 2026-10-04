package com.restaurant.bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Restaurant Order System ===\n");

        // 1. Dine-In Order paid with Cash
        PaymentProcessor cash = new CashPayment();
        Order dineIn = new DineInOrder(cash, 40.00, 7);
        dineIn.completeOrder();

        System.out.println("\n------------------------------------------------\n");

        // 2. Delivery Order paid with Credit Card
        PaymentProcessor card = new CreditCardPayment("4111222233334444");
        Order delivery = new DeliveryOrder(card, 65.00, "Tauelsizdik 5, Astana");
        delivery.completeOrder();

        System.out.println("\n------------------------------------------------\n");

        // 3. Dynamic Implementation Switching at Runtime
        System.out.println("Customer changed mind: Switching Dine-In Order payment method to Credit Card...");
        dineIn.setPaymentProcessor(card);
        dineIn.completeOrder();
    }
}