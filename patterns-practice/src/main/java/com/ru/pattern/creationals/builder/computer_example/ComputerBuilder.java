package com.ru.pattern.creationals.builder.computer_example;

/**
 * ! Patrón Builder:
 * Es un patrón de diseño creacional que nos permite construir objetos complejos
 * paso a paso.
 *
 * El patrón nos permite producir distintos tipos y representaciones
 * de un objeto empleando el mismo código de construcción.
 *
 * * Es útil cuando necesitamos construir un objeto complejo con muchas partes
 * * y queremos que el proceso de construcción sea independiente de las partes
 * * que lo componen.
 *
 * https://refactoring.guru/es/design-patterns/builder
 */

public class ComputerBuilder {

    private Computer computer;

    public ComputerBuilder() {
        this.computer = new Computer();
    }

    public ComputerBuilder setCpu(String cpu){
        this.computer.cpu = cpu;
        return this;
    }
    public ComputerBuilder setRam(String ram){
        this.computer.ram = ram;
        return this;
    }
    public ComputerBuilder setStorage(String storage){
        this.computer.storage = storage;
        return this;
    }
    public ComputerBuilder setGpu(String gpu){
        this.computer.gpu = gpu;
        return this;
    }

    public Computer build(){
        return computer;
    }
}
