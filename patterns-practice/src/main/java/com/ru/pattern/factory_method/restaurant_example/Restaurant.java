package com.ru.pattern.factory_method.restaurant_example;

public abstract class Restaurant {

    protected abstract Burger createBurger();

    public void orderBurger(){
        Burger burger = createBurger();
        burger.prepare();
    }
}
