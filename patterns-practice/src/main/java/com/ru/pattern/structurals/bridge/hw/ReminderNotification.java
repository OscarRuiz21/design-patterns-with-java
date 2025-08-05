package com.ru.pattern.structurals.bridge.hw;

public class ReminderNotification extends Notification{

    ReminderNotification(NotificationChannel channel) {
        super(channel);
    }
    @Override
    void sendNotification(String message) {
        channel.send("Reminder notification with message: " + message);
    }
    @Override
    void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}
