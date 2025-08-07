package com.ru.pattern.structurals.bridge.hw;

public class AlertNotification extends Notification{

    public AlertNotification(NotificationChannel channel) {
        super(channel);
    }

    @Override
    void sendNotification(String message) {
        channel.send("Alert notification with message: " + message);
    }

    @Override
    void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

}
