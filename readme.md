# Restaurant Order System — Strategy Pattern

## 1. Product Description
The **Restaurant Order System** implements the **Strategy Design Pattern** to manage interchangeable discount algorithms (`NoDiscountStrategy`, `PercentageDiscountStrategy`, `FlatDiscountStrategy`). The `OrderContext` delegates discount calculation to an encapsulated strategy interface, eliminating conditional branching (`if`/`switch`) and enabling dynamic strategy switching at runtime.

## 2. Technical Requirements
*   **Strategy Interface:** `DiscountStrategy` — defines the `applyDiscount(double originalTotal)` contract.
*   **Concrete Strategies:**
   1. `NoDiscountStrategy` — charges standard full price.
   2. `PercentageDiscountStrategy` — applies percentage reduction (e.g., 20% off for VIPs).
   3. `FlatDiscountStrategy` — applies fixed dollar deduction (e.g., $15 coupon).
*   **Context:** `OrderContext` — holds reference to `DiscountStrategy`, delegates execution, and supports runtime strategy replacement (`setDiscountStrategy`).
*   **Client:** `Main` — configures strategies directly at runtime without `if`/`switch` branching inside the Context.

## 3. Clean Code Requirements
1. **Elimination of Branching Logic:** Replaces conditional checks with polymorphic delegation (`discountStrategy.applyDiscount(...)`).
2. **Intention-Revealing Names:** Strategy class names reflect explicit algorithmic behavior (`PercentageDiscountStrategy`, `FlatDiscountStrategy`).
3. **Single Responsibility Principle (SRP):** Each strategy class isolates a single pricing algorithm.
4. **Context Algorithm-Agnosticism:** `OrderContext` has zero knowledge of concrete discount calculations.
5. **Open/Closed Principle (OCP):** Adding a new pricing strategy (e.g., `BuyOneGetOneFreeStrategy`) requires no changes to `OrderContext` or existing strategy classes.

## 4. Deliverables
*   **GitHub Repository:** Complete, compiling Java source code in a clean package structure.