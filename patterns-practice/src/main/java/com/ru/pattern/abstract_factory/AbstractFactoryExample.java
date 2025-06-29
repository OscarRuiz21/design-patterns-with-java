package com.ru.pattern.abstract_factory;

public class AbstractFactoryExample {

    public static void main(String[] args) {

        System.out.println( "Abstract Factory Example");

        System.out.println(".....");
        System.out.println( "== Creating Healty Restaurant ==");

        serveMeal(new HealtyRestaurant());
        System.out.println("Meal served");

        System.out.println(".....");
        System.out.println( "== Creating Fast Food Restaurant ==");

        serveMeal(new FastFoodRestaurant());
        System.out.println("Meal served");

    }

    private static void serveMeal(RestaurantFactory restaurantFactory) {
        restaurantFactory.createBurger().cook();
        restaurantFactory.createDrink().pour();
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

