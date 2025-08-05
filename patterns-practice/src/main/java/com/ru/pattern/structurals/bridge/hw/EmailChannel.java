package com.ru.pattern.structurals.bridge.hw;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Enviando correo electrónico: " + message);
    }
}
