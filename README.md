# Restaurant Order System (Factory pattern)

## 1. Task Description
Implementation of the Factory Method pattern (Part A) for a restaurant order system.

## 2. Technical Requirements
 Product:** The `Meal` interface defining the common contract for created objects (`prepare()`, `serve()`).
      Concrete Product:** `VeganMeal` and `SteakMeal` (at least two concrete implementations).
      Creator:** The `Restaurant` abstract class declaring the factory method `createMeal()`.
      Concrete Creator:** `VeganRestaurant` and `SteakhouseRestaurant` (at least two), each producing a specific Concrete Product.

## 3. Clean Code Requirements
At least five Clean Code principles are explicitly identified and applied in this implementation:

1.    Meaningful, intention-revealing names:
    Class and method names clearly reflect their purpose and intent.
        Before: `public abstract class Creator { abstract Product doStuff(); }`
        After: `public abstract class Restaurant { protected abstract Meal createMeal(); }`
2.    Small methods, each doing one thing:
    The `orderMeal()` method solely orchestrates the process, while the actual creation logic is delegated to `createMeal()`.
        Excerpt: 
        ```java
        public Meal orderMeal() {
            Meal meal = createMeal();
            meal.prepare();
            return meal;
        }
        ```
3.    Consistent formatting and small, focused classes:
    Each product and creator resides in its own separate file with a single responsibility. For example, `VeganMeal` is exclusively responsible for the logic of preparing a vegan dish.
4.    No magic numbers/strings:
    Instead of passing string parameters (e.g., `"vegan"`, `"steak"`) into a `switch` statement to select a meal, the code uses polymorphism and concrete factory classes, entirely eliminating "magic strings".
5.    Validated construction:
    Within the abstract `Restaurant` class, the `orderMeal()` method guarantees that the `Meal` object is instantiated and prepared in the strictly correct sequence. The client cannot receive a meal in an invalid or unprepared state.


## Code Explanation and Factory Method Workflow

### How the Factory Method Pattern Works
The Factory Method pattern delegates the object creation logic to subclasses. Instead of calling a constructor directly via the `new` keyword within the client code, we invoke a specialized factory method.

### Code Breakdown:
1.  Separating Creation from Usage: The abstract `Restaurant` class contains a core method called `orderMeal()`. This method knows *how* to interact with a meal (calling `prepare()` and `serve()`), but it does not know which specific meal it is working with.
2.  Delegation to Subclasses: To obtain the actual meal instance, `Restaurant` calls the `createMeal()` method. This method is declared as abstract.
3.  Concretization: When we implement the `SteakhouseRestaurant` (a Concrete Creator), we override the `createMeal()` method so that it returns a `new SteakMeal()`.
4.  The Advantage: If we need to add a `SushiRestaurant` in the future, we **do not have to modify the existing code** of the `Restaurant` or the `Main` client class. We simply create a new `SushiMeal` (Product) and a `SushiRestaurant` (Creator).
