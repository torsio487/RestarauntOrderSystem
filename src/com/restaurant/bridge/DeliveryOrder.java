package com.restaurant.bridge;

public class DeliveryOrder extends Order {
    private final String deliveryAddress;
    private static final double FLAT_DELIVERY_FEE = 5.00;

    public DeliveryOrder(PaymentProcessor paymentProcessor, double baseAmount, String deliveryAddress) {
        super(paymentProcessor, baseAmount);
        if (deliveryAddress == null || deliveryAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Delivery address cannot be empty.");
        }
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public double calculateTotal() {
        return baseAmount + FLAT_DELIVERY_FEE;
    }

    @Override
    public void completeOrder() {
        double total = calculateTotal();
        System.out.println("Completing Delivery Order to: " + deliveryAddress);
        System.out.println("Order Subtotal: $" + String.format("%.2f", baseAmount) + " | Delivery Fee: $" + String.format("%.2f", FLAT_DELIVERY_FEE));
        paymentProcessor.processPayment(total);
    }
}
