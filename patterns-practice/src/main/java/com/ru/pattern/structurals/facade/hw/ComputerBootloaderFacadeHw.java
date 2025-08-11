package com.ru.pattern.structurals.facade.hw;

public class ComputerBootloaderFacadeHw {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();

        // Encender la computadora usando la fachada
        computer.startComputer();

        // Apagar la computadora usando la fachada
        computer.shutDownComputer();
    }
}

class CPU {
    public void stopOperations() {
        System.out.println("CPU: Deteniendo operaciones.");
    }

    public void jump(int position) {
        System.out.println("CPU: Saltando a la posición de memoria " + position + ".");
    }

    public void execute() {
        System.out.println("CPU: Ejecutando instrucciones.");
    }
}

class HardDrive {
    public String read(int position, int size) {
        System.out.println("HardDrive: Leyendo " + size + " bytes desde la posición " + position + ".");
        return "001010001010100";
    }

    public void close() {
        System.out.println("HardDrive: Deteniendo disco duro.");
    }
}

class Memory {
    public void load(int position, String data) {
        System.out.println("Memory: Cargando datos en la posición " + position + " " + data + ".");
    }

    public void free() {
        System.out.println("Memory: Liberando memoria.");
    }
}

// 2. Clase Facade - ComputerFacade

class ComputerFacade {
    // Atributos necesarios
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    // Constructor para instanciar los atributos
    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        System.out.println("\nIniciando la computadora...");

        // Operaciones necesarias para encender la computadora
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();

        System.out.println("Computadora lista para usar.\n");
    }

    public void shutDownComputer() {
        System.out.println("\nApagando la computadora...");
        System.out.println("Cerrando procesos y guardando datos...");

        // Operaciones necesarias para apagar la computadora
        cpu.stopOperations();
        memory.free();
        hardDrive.close();

        System.out.println("Computadora apagada.\n");
    }
}
