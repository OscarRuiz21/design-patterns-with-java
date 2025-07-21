package com.ru.pattern.creationals.factory_function;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class LoggerApp {

    enum LogLevel {
        INFO, WARN, ERROR
    }

    static class Colors {
        public static final String RED = "\u001B[31m"; // ANSI rojo (para consola)
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String RESET = "\u001B[0m";
    }

    public static Consumer<String> createLogger(LogLevel level) {
        return message -> {
            Map<LogLevel, String> messages = new HashMap<>();
            messages.put(LogLevel.INFO, Colors.GREEN + message + Colors.RESET + " TEST");
            messages.put(LogLevel.WARN, Colors.YELLOW + message + Colors.RESET + " TEST");
            messages.put(LogLevel.ERROR, Colors.RED + message + Colors.RESET + " TEST");

            System.out.println(messages.get(level));
        };
    }

    public static void main(String[] args) {
        Consumer<String> infoLogger = createLogger(LogLevel.INFO);
        Consumer<String> warnLogger = createLogger(LogLevel.WARN);
        Consumer<String> errorLogger = createLogger(LogLevel.ERROR);

        infoLogger.accept("this is an info message, all is ok! :D");
        warnLogger.accept("this is an warn message, looks something could be wrong :/");
        errorLogger.accept("this is an error message, something went wrong :(");
    }
}
