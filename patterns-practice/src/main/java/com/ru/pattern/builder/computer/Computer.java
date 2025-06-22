package com.ru.pattern.builder.computer;

public class Computer {
    public String cpu;
    public String ram;
    public String storage;
    public String gpu;


    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }
}
