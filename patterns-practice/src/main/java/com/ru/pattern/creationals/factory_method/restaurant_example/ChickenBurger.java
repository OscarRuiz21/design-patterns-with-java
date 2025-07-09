package com.ru.pattern.creationals.factory_method.restaurant_example;

public class ChickenBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Preparing Chicken Burger");
    }
}
