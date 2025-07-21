package com.ru.pattern.structurals.adapter.hw.services;

public class PayPalService {

    public void sendPayment(double amount){
        System.out.println(ANSI_BLUE + "Paying " + amount + " using PayPal" + ANSI_RESET);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";
}
