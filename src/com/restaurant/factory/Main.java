package com.restaurant.factory;

public class Main {
    public static void main(String[] args) {
        // Client works only with abstract method Creator
        Restaurant myVeganPlace = new VeganRestaurant();
        myVeganPlace.orderMeal();

        Restaurant mySteakhouse = new SteakhouseRestaurant();
        mySteakhouse.orderMeal();
    }
}