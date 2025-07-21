package com.ru.pattern.structurals.adapter.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ! Patrón Adapter
 *  Permite que objetos con interfaces incompatibles trabajen juntos, también es muy
 *  util para utilizar librerías de terceros en nuestra aplicación sin depender
 *  directamente de ellas.
 *
 * * Es útil cuando se quiere reutilizar una clase que no tiene la interfaz que
 * * necesitamos o cuando queremos crear una capa de abstracción para una librería
 * * de terceros.
 *
 * https://refactoring.guru/es/design-patterns/adapter
 */



public class Adapter {

    private static final LoggerAdapter localLogger = new LoggerAdapter("Adapter.class");
    //private static LocalLogger localLogger = new LocalLogger("01-Adapter.class ");

    public static void main(String[] args) {

        localLogger.writeLog(" Este es un log");
        localLogger.writeWarning(" Este es un warning");
        localLogger.writeError(" Este es un error");
    }

}

