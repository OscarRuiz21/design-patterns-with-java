package com.ru.pattern.creationals.factory_method.restaurant_example;

public class BeefBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Beef Burger");
    }
}
