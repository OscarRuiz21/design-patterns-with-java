package com.ru.pattern.creationals.factory_method.restaurant_example;

public class BeefRestaurant extends Restaurant {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
