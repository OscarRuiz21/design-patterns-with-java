package com.ru.pattern.structurals.bridge.hw_upgrade;

import java.util.List;

public abstract class Notification {
    protected List<NotificationChannel> channels;

    public Notification(List<NotificationChannel> channels) {
        this.channels = channels;
    }
    abstract void sendNotification(String message);
    public abstract void addChannel(NotificationChannel channel);
}
