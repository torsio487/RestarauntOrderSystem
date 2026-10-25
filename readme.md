#  Restaurant Order System (Bridge Pattern)

## Project Overview
This project is an implementation of the Bridge structural design pattern in Java, developed for Assignment #3 (Software Design Patterns). 

The chosen topic is a Restaurant Order System. It decouples the type of order (Dine-In, Delivery) from the payment method (Cash, Credit Card). This separation allows both hierarchies to evolve independently, preventing a cartesian product of classes (e.g., `DineInCashOrder`, `DineInCreditOrder`, `DeliveryCashOrder`, etc.).

## Bridge Pattern Components

Based on the assignment requirements, the classes are mapped to the Bridge pattern roles as follows:

| Pattern Component | Implemented Class(es) | Description |
| :--- | :--- | :--- |
| Abstraction | `Order.java` | An abstract class that maintains a reference to the `PaymentProcessor` (Implementor) and defines the core order behaviors. |
| Refined Abstraction | `DineInOrder.java`<br>`DeliveryOrder.java` | Extensions of `Order`. Each adds specific business logic for calculating totals (e.g., 10% service fee for Dine-In, flat $5 fee for Delivery). |
| Implementor | `PaymentProcessor.java` | An interface defining the low-level operations for processing payments. |
| Concrete Implementor | `CashPayment.java`<br>`CreditCardPayment.java` | Concrete implementations of the payment methods. |
| Client | `Main.java` | Composes the abstractions and implementors at runtime and demonstrates dynamic switching of implementations. |

## Clean Code Requirements Applied

The following Clean Code principles have been strictly adhered to in this project:

1. **Clear Separation of Responsibilities:**
   The abstraction side (`Order`) strictly handles order-related business logic (subtotals, service fees, delivery fees). The implementation side (`PaymentProcessor`) is purely responsible for transaction execution. The implementor details are never leaked into the client or abstraction logic.
2. **Meaningful & Distinguishing Names:**
   Class names clearly indicate their role in the bridge. `Order` and its subclasses denote the high-level concept, while `PaymentProcessor` and its implementations explicitly denote the low-level execution engines. 
3. **Small, Focused Classes (Single Responsibility Principle):**
   Each class has a single reason to change. For instance, `CreditCardPayment` is solely responsible for masking card numbers and processing card payments, while `DeliveryOrder` only cares about its flat delivery fee logic.
4. **Open/Closed Principle (Backward-compatible design):**
   The system is highly extensible. Adding a new `TakeoutOrder` requires absolutely no changes to the payment classes. Similarly, introducing a new `CryptoPayment` class requires zero changes to the `Order` hierarchy. 
5. **Fail-Fast & Defensive Programming:**
   Constructors enforce valid states immediately. `Order` rejects null payment processors or negative amounts. `CreditCardPayment` throws an `IllegalArgumentException` if the card number is empty, preventing invalid objects from propagating through the system.

## How to Run

1. **Compile the code:**
   ```bash
   javac -d bin src/com/restaurant/bridge/*.java
   ```
2. **Run the application:**
   ```bash
   java -cp bin com.restaurant.bridge.Main
   ```

## Expected Output

```text
=== Restaurant Order System ===

Completing Dine-In Order for Table #7
Order Subtotal: $40.00 | Service Fee (10%): $4.00
Paid $44.00 in Cash at the register/courier.

------------------------------------------------

Completing Delivery Order to: Tauelsizdik 5, Astana
Order Subtotal: $65.00 | Delivery Fee: $5.00
Paid $70.00 using Credit Card [****-****-****-4444].

------------------------------------------------

Customer changed mind: Switching Dine-In Order payment method to Credit Card...
Completing Dine-In Order for Table #7
Order Subtotal: $40.00 | Service Fee (10%): $4.00
Paid $44.00 using Credit Card [****-****-****-4444].
```