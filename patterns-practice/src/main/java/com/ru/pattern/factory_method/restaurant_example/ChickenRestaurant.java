package com.ru.pattern.factory_method.restaurant_example;

public class ChickenRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }

}
