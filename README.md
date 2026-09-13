# Restaurant Order System (Builder Pattern)

## Product Description
A system for step-by-step construction of complex restaurant orders (main dish, side, drink, dessert, takeaway flag)

## 1. Meaningful, Intention-Revealing Names

Principle: Classes, methods, and variables should have names that clearly state their purpose, making the code read like prose without requiring comments.

Applied in: `OrderDirector.java` and `Order.java`.

Example:
Before (Poor Naming):
```java
public Order buildMeal1(OrderBuilder b) { ... }
```

After (Applied Principle):
```java
public Order constructStandardBurgerCombo(OrderBuilder builder) {
    return builder.setMainDish("Baconator")
            .setSideDish("Fries")
            .setDrink("Cola")
            .setTakeaway(true)
            .build();
}
```
Justification: The method name `constructStandardBurgerCombo` explicitly describes exactly what configuration is being created, leaving no ambiguity. Similarly, using boolean flags with clear prefixes like `isTakeaway` in `Order.java` instantly reveals that the variable represents a boolean condition.

## 2. Small Methods, Each Doing One Thing (Single Responsibility)

Principle: Methods should be short, strictly do one thing, and have no side effects.

Applied in: `RestarauntOrderBuilder.java`.

Example:
Before (A monolithic method):
```java
public void setupOrder(String main, String side, boolean takeaway) {
    this.mainDish = main;
    this.sideDish = side;
    this.isTakeaway = takeaway;
}
```

After (Applied Principle):
```java
@Override
public OrderBuilder setMainDish(String mainDish) {
    this.mainDish = mainDish;
    return this; // chaining method
}
```
Justification: Each method in the builder, such as `setMainDish` or `setTakeaway`, is extremely concise and responsible for setting exactly one field before returning `this` for method chaining.

## 3. Consistent Formatting and Small, Focused Classes

Principle: Classes should adhere to the Single Responsibility Principle, remaining small and focused on one conceptual task.

Applied in: `Order.java` and `OrderDirector.java`.

Example:
```java
public class OrderDirector {

    public Order constructStandardBurgerCombo(OrderBuilder builder) {
        return builder.setMainDish("Baconator")
                .setSideDish("Fries")
                .setDrink("Cola")
                .setTakeaway(true)
                .build();
    }

    public Order constructHealthyVeganMeal(OrderBuilder builder) {
        return builder.setMainDish("Caesar Salad")
                .setDrink("Smoothie")
                .setDessert("Fruit Bowl")
                .setTakeaway(false)
                .build();
    }
}
```
Justification: The codebase separates responsibilities into small classes. `Order.java` serves exclusively as a data container, `RestarauntOrderBuilder.java` handles the step-by-step construction logic, and `OrderDirector.java` focuses purely on orchestrating predefined meal configurations. No class is bloated.

## 4. Validated Construction

Principle: Objects should not be allowed to exist in an invalid state. Constraints must be checked before or during object creation.

Applied in: `RestarauntOrderBuilder.java` and tested in `Main.java`.

Example:
Excerpt from `RestarauntOrderBuilder.java`:*
```java
@Override
public Order build() {
    // Validated construction: enforcing a required field
    if (mainDish == null || mainDish.trim().isEmpty()) {
        throw new IllegalStateException("Cannot build order: A main dish is required.");
    }
    return new Order(mainDish, sideDish, drink, dessert, isTakeaway);
}
```
Justification: The `build()` method enforces a critical business invariant: an order cannot exist without a main dish. By throwing an `IllegalStateException` here, it guarantees that any instantiated `Order` object is always valid and safe to use.

## 5. Eliminating Magic Arguments

Principle: Passing mysterious literal values (like `true/false` or `null`) directly into constructors obscures intent. The Builder pattern fixes the "Magic Arguments" anti-pattern.

Applied in: `Main.java`.

Example:
Before (Using a standard constructor with magic positional arguments):*
```java
Order customOrder = new Order("Grilled Steak", "Mashed Potatoes", null, null, false);
```

After (Applied Principle using Fluent Builder):*
```java
Order customOrder = new RestarauntOrderBuilder()
        .setMainDish("Grilled Steak")
        .setSideDish("Mashed Potatoes")
        .setTakeaway(false)
        .build();
```
Justification: In the "Before" example, `null, null, false` are magic values—the reader has no idea what they represent without inspecting the constructor signature. The current implementation uses explicit method names (`setTakeaway(false)`), making the intent of every value clear and removing magic positional arguments.
