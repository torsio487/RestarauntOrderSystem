package com.restaurant.bridge;

public class DineInOrder extends Order {
    private final int tableNumber;
    private static final double SERVICE_FEE_RATE = 0.10; // 10% service fee

    public DineInOrder(PaymentProcessor paymentProcessor, double baseAmount, int tableNumber) {
        super(paymentProcessor, baseAmount);
        if (tableNumber <= 0) {
            throw new IllegalArgumentException("Table number must be positive.");
        }
        this.tableNumber = tableNumber;
    }

    @Override
    public double calculateTotal() {
        return baseAmount + (baseAmount * SERVICE_FEE_RATE);
    }

    @Override
    public void completeOrder() {
        double total = calculateTotal();
        System.out.println("Completing Dine-In Order for Table #" + tableNumber);
        System.out.println("Order Subtotal: $" + String.format("%.2f", baseAmount) + " | Service Fee (10%): $" + String.format("%.2f", baseAmount * SERVICE_FEE_RATE));
        paymentProcessor.processPayment(total);
    }
}