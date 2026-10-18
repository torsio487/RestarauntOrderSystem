package com.restaurant.facade;

public class Main {
    public static void main(String[] args) {
        // Client interacts exclusively with the Facade
        RestaurantOrderFacade orderFacade = new RestaurantOrderFacade();

        // Placing a complex order via a single clean method call
        orderFacade.placeCompleteOrder(
                "T-bone Steak",
                45.50,
                "ACC-668877",
                5,
                "Mangilik El 12, Astana"
        );
    }
}