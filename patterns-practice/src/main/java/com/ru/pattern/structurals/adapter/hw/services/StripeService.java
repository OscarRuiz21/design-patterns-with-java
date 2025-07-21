package com.ru.pattern.structurals.adapter.hw.services;

public class StripeService {

    public void makeCharge(double amount){
        System.out.println(ANSI_RED + "Paying " + amount + " using Stripe" + ANSI_RESET);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
}

