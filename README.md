# Restaurant Order System (Facade Pattern)

## 1. Product Description
The Restaurant Order System applies the Facade Design Pattern to hide the complex interactions among multiple internal subsystems (`InventoryStockChecker`, `PaymentGateway`, `KitchenWorkflowManager`, `DeliveryDispatcher`). Instead of forcing the client to coordinate these components manually, the `RestaurantOrderFacade` provides a single, simplified method (`placeCompleteOrder`) to execute the entire workflow safely.

## 2. Technical Requirements
*   Complex Subsystem: Contains four collaborating classes with distinct responsibilities:
    1. `InventoryStockChecker` — validates and updates ingredient storage.
    2. `PaymentGateway` — processes financial account charges.
    3. `KitchenWorkflowManager` — transmits cooking tickets to the kitchen.
    4. `DeliveryDispatcher` — handles courier assignment and dispatching.
*   Facade: `RestaurantOrderFacade` — orchestrates subsystem sequence in the correct logical order.
*   Client: `Main` — interacts strictly with the Facade and never instantiates or calls subsystem classes directly.

## 3. Clean Code Requirements
1. Meaningful Names: Classes and methods use self-explanatory domain terminology (`InventoryStockChecker`, `placeCompleteOrder`).
2. Single Responsibility Principle (SRP): The Facade exclusively coordinates workflow orchestration without duplicating low-level subsystem logic.
3. No Leaking Details: Internal subsystem classes and states remain fully encapsulated behind the Facade interface.
4. Small, Focused Classes: Each subsystem class maintains a single, highly cohesive responsibility.
5. Proper Error Handling: Validates stock and payment states, throwing explicit exceptions (`IllegalStateException`, `RuntimeException`) if coordination fails.

## 4. Deliverables
*   GitHub Repository: Complete, compiling Java source code organized in a clean package structure.
