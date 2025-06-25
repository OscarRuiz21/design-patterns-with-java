package com.ru.pattern.factory_method.restaurant_example;

public abstract class Restaurant {

    abstract Burger createBurger();

    public void orderBurger(){
        Burger burger = createBurger();
        burger.prepare();
    }
}
