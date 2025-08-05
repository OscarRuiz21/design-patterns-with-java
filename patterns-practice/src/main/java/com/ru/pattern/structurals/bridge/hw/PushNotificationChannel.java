package com.ru.pattern.structurals.bridge.hw;

public class PushNotificationChannel implements NotificationChannel {

    @Override
    public void send(String message) {
        System.out.println("Enviando Push: " + message);
    }
}