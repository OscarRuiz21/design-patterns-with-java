package com.ru.pattern.structurals.bridge.hw_upgrade;

import java.util.List;

public class ReminderNotification extends Notification {

    public ReminderNotification(List<NotificationChannel> channels) {
        super(channels);
    }

    @Override
    void sendNotification(String message) {
        System.out.println("\n[REMINDER] Notificación de reminder:");
        for (NotificationChannel channel : channels) {
            channel.send(message);
        }
    }

    @Override
    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}
