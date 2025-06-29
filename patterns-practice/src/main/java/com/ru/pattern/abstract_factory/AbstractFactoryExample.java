package com.ru.pattern.abstract_factory;

public class AbstractFactoryExample {

    public static void main(String[] args) {

        System.out.println( "Abstract Factory Example");

        System.out.println( "Creating Healty Restaurant");
        RestaurantFactory factory = new HealtyRestaurant();
        factory.createBurger().cook();
        factory.createDrink().pour();

        System.out.println( "Creating Fast Food Restaurant");
        RestaurantFactory factory2 = new FastFoodRestaurant();
        factory2.createBurger().cook();
        factory2.createDrink().pour();
    }

}

interface Burger {

    void cook();
}

interface Drink {

    void pour();
}

class ChickenBurger implements Burger {
    @Override
    public void cook() {
        System.out.println("Chicken Burger cooked!");
    }
}

class BeefBurger implements Burger {
    @Override
    public void cook() {
        System.out.println("Beef Burger cooked!");
    }
}

class Water implements Drink {
    @Override
    public void pour() {
        System.out.println("Water pour!");
    }
}


class Soda implements Drink {
    @Override
    public void pour() {
        System.out.println("Soda pour!");
    }
}

interface RestaurantFactory {
    Burger createBurger();
    Drink createDrink();
}


class FastFoodRestaurant implements RestaurantFactory {
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }

    @Override
    public Drink createDrink() {
        return new Soda();
    }
}

class HealtyRestaurant implements RestaurantFactory {
    @Override
    public Burger createBurger() {
        return new ChickenBurger();
    }
    @Override
    public Drink createDrink() {
        return new Water();
    }
}
