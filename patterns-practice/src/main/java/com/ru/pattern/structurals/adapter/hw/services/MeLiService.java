package com.ru.pattern.structurals.adapter.hw.services;

public class MeLiService {

    public void pay(double amount){
        System.out.println(ANSI_YELLOW + "Paying " + amount + " using MeLi" + ANSI_RESET);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_YELLOW = "\u001B[33m";
}
