package com.ru.pattern.builder;

import com.ru.pattern.builder.computer.Computer;
import com.ru.pattern.builder.computer.ComputerBuilder;

public class Main {
    public static void main(String[] args) {

        Computer computer = new ComputerBuilder()
                .setCpu("cpu a")
                .setRam("Ram b")
                .setStorage("storage c")
                .setGpu("gpu c")
                .build();

        System.out.println(computer);
    }
}
