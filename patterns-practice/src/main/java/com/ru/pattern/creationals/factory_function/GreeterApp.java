package com.ru.pattern.creationals.factory_function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class GreeterApp {

    enum Language{
        ES, EN, FR
    }

    static class Colors {
        public static final String RED = "\u001B[31m"; // ANSI rojo (para consola)
        public static final String RESET = "\u001B[0m";
    }

    public static Consumer<String> createGreeter(Language lang) {
        return name -> {
            Map<Language, String> messages = new HashMap<>();
            messages.put(Language.ES, "Hola, " + Colors.RED + name + Colors.RESET + "!");
            messages.put(Language.EN, "Hello, " + Colors.RED + name + Colors.RESET + "!");
            messages.put(Language.FR, "Bonjour, " + Colors.RED + name + Colors.RESET + "!");

            System.out.println(messages.get(lang));
        };
    }

    public static void main(String[] args) {
        Consumer<String> spanishGreeter = createGreeter(Language.ES);
        Consumer<String> englishGreeter = createGreeter(Language.EN);
        Consumer<String> frenchGreeter = createGreeter(Language.FR);


        spanishGreeter.accept("Fernando");
        englishGreeter.accept("Alice");
        frenchGreeter.accept("Pierre");

    }
}
