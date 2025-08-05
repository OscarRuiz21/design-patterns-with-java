package com.ru.pattern.structurals.bridge.hw;

public class SMSChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}
