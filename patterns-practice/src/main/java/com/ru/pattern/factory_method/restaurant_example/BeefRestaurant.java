package com.ru.pattern.factory_method.restaurant_example;

public class BeefRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
