package com.ru.pattern.structurals.flyweight.ex;

import java.util.HashMap;
import java.util.Map;

// Cliente
public class ShapeFlyweightEx {
    public static void main(String[] args) {
        Shape redCircle = ShapeFactory.getCircle("Rojo");
        redCircle.draw(10, 20);

        Shape anotherRedCircle = ShapeFactory.getCircle("Rojo");
        anotherRedCircle.draw(30, 40);

        // Ambas referencias usan el mismo objeto en memoria
    }
}

// Flyweight
interface Shape {
    void draw(int x, int y); // Estado extrínseco: coordenadas
}

// ConcreteFlyweight
class Circle implements Shape {
    private final String color; // Estado intrínseco

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Dibujando círculo color " + color + " en (" + x + ", " + y + ")");
    }
}

// FlyweightFactory
class ShapeFactory {
    private static final Map<String, Shape> circles = new HashMap<>();

    public static Shape getCircle(String color) {
        Shape circle = circles.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circles.put(color, circle);
        }
        return circle;
    }
}

