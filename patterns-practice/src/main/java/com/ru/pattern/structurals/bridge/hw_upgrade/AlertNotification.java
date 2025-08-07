package com.ru.pattern.structurals.bridge.hw_upgrade;

import java.util.List;

public class AlertNotification extends Notification {

    public AlertNotification(List<NotificationChannel> channels) {
        super(channels);
    }

    @Override
    void sendNotification(String message) {
        System.out.println("\n[ALERTA] Notificación de alerta:");
        for (NotificationChannel channel : channels) {
            channel.send(message);
        }
    }

    @Override
    public void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

}
