package com.ru.pattern.factory_method.restaurant_example;

public class BeefBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Beef Burger");
    }
}
