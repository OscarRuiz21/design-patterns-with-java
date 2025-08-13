package com.ru.pattern.structurals.flyweight.ex;

import java.util.*;

/**
 * ! Patrón Flyweight
 * Es un patrón de diseño estructural que nos permite usar objetos compartidos
 * para soportar eficientemente grandes cantidades de objetos.
 *
 * * Es útil cuando necesitamos una gran cantidad de objetos y queremos reducir
 * * la cantidad de memoria que utilizan.
 *
 * https://refactoring.guru/es/design-patterns/flyweight
 */

public class FlyweightEx {

    public static void main(String[] args) {
        LocationFactory factory = new LocationFactory();

        List<MapLocation> locations = new ArrayList<>(Arrays.asList(
                new MapLocation(10, 20, factory.getLocationIcon("hospital")),
                new MapLocation(20, 40, factory.getLocationIcon("hospital")),
                new MapLocation(30, 60, factory.getLocationIcon("hospital")),

                new MapLocation(35, 65, factory.getLocationIcon("parque")),
                new MapLocation(35, 65, factory.getLocationIcon("parque")),
                new MapLocation(35, 65, factory.getLocationIcon("parque")),
                new MapLocation(35, 65, factory.getLocationIcon("parque")),
                new MapLocation(35, 65, factory.getLocationIcon("parque")),
                new MapLocation(35, 65, factory.getLocationIcon("parque")),
                new MapLocation(35, 65, factory.getLocationIcon("parque")),

                new MapLocation(30, 60, factory.getLocationIcon("hospital")),
                new MapLocation(30, 60, factory.getLocationIcon("hospital")),
                new MapLocation(30, 60, factory.getLocationIcon("hospital")),
                new MapLocation(30, 60, factory.getLocationIcon("hospital")),

                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela")),
                new MapLocation(30, 60, factory.getLocationIcon("Escuela"))
        ));

        locations.forEach(MapLocation::display);
    }
}

interface Location{
    void display(Coordinates coordinates);
}

// Clase que representa una ubicación concreta en el mapa
class Coordinates {
    final int x;
    final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//Flyweight
class LocationIcon implements Location{
    private String type; // hospital, escuela, parque
    private String iconImage; // imagen del marcador

    public LocationIcon(String type, String iconImage) {
        this.type = type;
        this.iconImage = iconImage;
    }
    @Override
    public void display(Coordinates coordinates) {
        System.out.println("Displaying icon "+ type +" at (" + coordinates.x + "," + coordinates.y + ") as " + iconImage);
    }
}


// Fábrica de Flyweights
// {
//   escuela: assets/school.png,
//   hospital: assets/hospital.png,
// }

class LocationFactory{

    private final Map<String, LocationIcon> icons = new HashMap<>();

    // Escuela, hospital, parque, ...
    public LocationIcon getLocationIcon(String type) {
        LocationIcon icon = icons.get(type);
        if (icon == null) {
            System.out.println("Creando una instancia del ícono de " + type);
            String iconImage = "imagen_de_" + type.toLowerCase() + ".png";
            icon = new LocationIcon(type, iconImage);
            icons.put(type, icon);
        }
        return icon;
    }
}

// Clase que representa una ubicación concreta en el mapa

class MapLocation{
    private final Coordinates coordinates;
    private final LocationIcon icon;

    public MapLocation(int x, int y, LocationIcon icon) {
        this.coordinates = new Coordinates(x, y);
        this.icon = icon;
    }

    public void display() {
        icon.display(coordinates);
    }
}