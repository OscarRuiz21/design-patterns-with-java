package com.ru.pattern.structurals.bridge.hw_upgrade;

import java.util.List;

public class PushNotification extends Notification {
    public PushNotification(List<NotificationChannel> channels) {
        super(channels);
    }

    @Override
    void sendNotification(String message) {
        System.out.println("\n[PUSH] Notificación sencilla:");
        for (NotificationChannel channel : channels) {
            channel.send(message);
        }
    }

    @Override
    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}
