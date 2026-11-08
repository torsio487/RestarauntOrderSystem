# Restaurant Order System — Visitor Pattern

## 1. Product Description
The **Restaurant Order System** implements the **Visitor Design Pattern** to perform unrelated operations (calculating total prices with taxes and computing estimated kitchen preparation times) over a stable menu item object structure (`FoodDish`, `Beverage`, `Dessert`) without altering their element classes. The system leverages **double dispatch** to eliminate type-checking chains (`instanceof`/`switch`) and enables seamless extensibility for new operations.

## 2. Technical Requirements
*   **Element Interface:** `MenuItem` — defines the `accept(OrderVisitor visitor)` double-dispatch contract.
*   **Concrete Elements:**
    1. `FoodDish` — represents food items with specific preparation times.
    2. `Beverage` — represents drink items with volume and alcohol flags.
    3. `Dessert` — represents sweet items with calorie metrics.
*   **Visitor Interface:** `OrderVisitor` — declares overloaded `visit()` methods for each concrete element type (`FoodDish`, `Beverage`, `Dessert`).
*   **Concrete Visitors:**
    1. `PriceCalculatorVisitor` — calculates item subtotal and applies relevant tax logic.
    2. `PreparationTimeVisitor` — computes total estimated order preparation time across all items.
*   **Object Structure:** `RestaurantOrder` — holds a collection of `MenuItem` objects and iterates through them to trigger `accept()`.
*   **Client:** `Main` — populates the order structure and executes visitors independently.

## 3. Clean Code Requirements
1. **Elimination of Type-Checking Chains:** Replaces `instanceof` and conditional branching with double dispatch (`item.accept(visitor)` -> `visitor.visit(this)`).
2. **Intention-Revealing Names:** Class and method names clearly reflect their structural or behavioral roles (`PriceCalculatorVisitor`, `PreparationTimeVisitor`, `accept`, `visit`).
3. **Single Responsibility Principle (SRP):** Each concrete visitor encapsulates a single operational algorithm across element types.
4. **Encapsulation Protection:** Internal element states are accessed via clean, read-only getter methods rather than exposing mutable fields.
5. **Open/Closed Principle (OCP):** Adding a new operation (e.g., `CalorieCalculatorVisitor`) requires no modifications to existing menu item element classes or the `MenuItem` interface.

## 4. Deliverables
*   **GitHub Repository:** Complete, compiling Java source code in a clean package structure.
