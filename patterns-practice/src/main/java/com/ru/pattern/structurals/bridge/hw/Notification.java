package com.ru.pattern.structurals.bridge.hw;

public abstract class Notification {
    protected NotificationChannel channel;

    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }
    abstract void sendNotification(String message);
    abstract void setChannel(NotificationChannel channel);
}
