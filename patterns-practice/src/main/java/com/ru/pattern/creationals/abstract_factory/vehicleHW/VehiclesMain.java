/**
 * ! Abstract Factory:
 * Es un patrón de diseño que permite crear familias de objetos relacionados
 * sin especificar sus clases concretas.
 *
 * En lugar de crear objetos individuales directamente,
 * creamos fábricas que producen un conjunto de objetos relacionados.
 *
 * * Es útil cuando necesitas crear objetos que son parte de una familia
 * * y quieres asegurarte de que estos objetos se complementen entre sí.
 *
 * https://refactoring.guru/es/design-patterns/abstract-factory
 */

package com.ru.pattern.creationals.abstract_factory.vehicleHW;

public class VehiclesMain {

    public static void main(String[] args) {
        System.out.println("Creating electric vehicle:");
        runFactory(new ElectricVehicleFactory());

        System.out.println("\nCreating gas vehicle:");
        runFactory(new GasVehicleFactory());
    }

    public static void runFactory(VehicleFactory factory) {
        Vehicle vehicle = factory.createVehicle();
        Engine engine = factory.createEngine();

        vehicle.assemble();
        engine.start();
    }

}

interface Vehicle {
    void assemble();
}

interface Engine {
    void start();
}

// 2. Clases Concretas de Productos

class ElectricCar implements Vehicle {
    @Override
    public void assemble() {
        System.out.println("Assembling electric car");
    }

}

class GasCar implements Vehicle {
    @Override
    public void assemble() {
        System.out.println("Assembling gas car");
    }
}

class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting electric engine");
    }

}

class GasEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Starting gas engine");
    }
}

// 3. Interfaz de la Fábrica Abstracta

interface VehicleFactory {
    Vehicle createVehicle();
    Engine createEngine();
}

// 4. Clases Concretas de Fábricas

class ElectricVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new ElectricCar();
    }

    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }
}

class GasVehicleFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new GasCar();
    }

    @Override
    public Engine createEngine() {
        return new GasEngine();
    }
}


