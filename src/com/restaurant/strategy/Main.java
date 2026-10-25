package com.restaurant.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT ORDER SYSTEM (STRATEGY PATTERN) ===\n");

        // 1. Regular order with no discount
        DiscountStrategy noDiscount = new NoDiscountStrategy();
        OrderContext order1 = new OrderContext("ORD-001", 100.0, noDiscount);
        order1.printSummary();

        // 2. VIP order with 20% discount
        DiscountStrategy vipDiscount = new PercentageDiscountStrategy(20.0);
        OrderContext order2 = new OrderContext("ORD-002", 100.0, vipDiscount);
        order2.printSummary();

        // 3. Promotional order with $15 flat coupon
        DiscountStrategy couponDiscount = new FlatDiscountStrategy(15.0);
        OrderContext order3 = new OrderContext("ORD-003", 100.0, couponDiscount);
        order3.printSummary();

        System.out.println("\n--- Switching Strategy at Runtime ---");
        // 4. Dynamic strategy change at runtime
        System.out.println("Applying promotional coupon to Order #1...");
        order1.setDiscountStrategy(couponDiscount);
        order1.printSummary();
    }
}
