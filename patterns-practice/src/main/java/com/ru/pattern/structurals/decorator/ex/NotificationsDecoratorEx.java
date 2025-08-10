package com.ru.pattern.structurals.decorator.ex;

/**
 * ! Patrón decorador
 * Es un patrón de diseño estructural que permite añadir
 * funcionalidades a objetos, colocando estos objetos dentro de
 * objetos encapsuladores especiales que contienen estas funcionalidades.
 **
 * * Es útil cuando necesitas añadir funcionalidades a objetos
 *  * de manera dinámica y flexible.
 *
 * https://refactoring.guru/es/design-patterns/decorator
 */
public class NotificationsDecoratorEx {
    public static void main(String[] args) {

        Notification basicNotification = new BasicNotification();
        basicNotification.send("This is a basic notification");

        System.out.println("-----------------");

        Notification emailNotification = new EmailNotificationDecorator(basicNotification);
        emailNotification.send("This is an email notification");

        System.out.println("-----------------");

        Notification smsNotification = new SMSNotificationDecorator(emailNotification);
        smsNotification.send("This is an sms notification");

        System.out.println("-----------------");


        Notification pushNotification = new PushNotificationDecorator(smsNotification);
        pushNotification.send("This is a push notification");
    }
}

interface Notification{
    void send(String message);
}

class BasicNotification implements Notification{

    @Override
    public void send(String message) {
        System.out.println("Sending basic notification: " + message);
    }

}

abstract class NotificationDecorator implements Notification{

    protected Notification notification;

    public NotificationDecorator(Notification notification){
        this.notification = notification;
    }

    @Override
    public void send(String message) {
        notification.send(message);
    }
}


class EmailNotificationDecorator extends NotificationDecorator{
    public EmailNotificationDecorator(Notification notification) {
        super(notification);
    }

    private void sendEmail(){
        System.out.println("Sending notification via email");
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendEmail();
    }
}

class SMSNotificationDecorator extends NotificationDecorator{
    public SMSNotificationDecorator(Notification notification) {
        super(notification);
    }

    private void sendSMS(){
        System.out.println("Sending notification via sms");
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS();
    }
}

class PushNotificationDecorator extends NotificationDecorator{
    public PushNotificationDecorator(Notification notification) {
        super(notification);
    }
    private void sendPush(){
        System.out.println("Sending notification via push");
    }
    @Override
    public void send(String message) {
        super.send(message);
        sendPush();
    }

}


