package com.ru.pattern.structurals.bridge.hw;

public class PushNotification extends Notification{
    public PushNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    void sendNotification(String message) {
        channel.send("Push notification with message: " + message);
    }

    @Override
    void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}
