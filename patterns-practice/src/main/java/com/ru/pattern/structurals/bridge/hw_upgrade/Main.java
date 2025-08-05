package com.ru.pattern.structurals.bridge.hw_upgrade;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<NotificationChannel> channels = Arrays.asList(
                new EmailChannel(),
                new SMSChannel(),
                new PushNotificationChannel(),
                new PushNotificationChannel(),
                new PushNotificationChannel(),
                new SMSChannel(),
                new EmailChannel()
        );

        AlertNotification alert = new AlertNotification(channels);
        alert.sendNotification("Alguien en frente de la casa");

        System.out.println();
    }
}
