package com.ru.pattern.structurals.bridge.hw;

public class BridgeHW {
    public static void main(String[] args) {
        // Crear una notificación de alerta usando el canal de correo electrónico
        AlertNotification alert = new AlertNotification(new EmailChannel());
        alert.sendNotification("Alerta de seguridad: Se ha detectado un acceso no autorizado.");

        // Cambiar el canal a SMS y volver a enviar la alerta
        alert.setChannel(new SMSChannel());
        alert.sendNotification("Alerta de seguridad: Se ha detectado un acceso no autorizado.");

        // Crear una notificación de recordatorio usando el canal de SMS
        ReminderNotification reminder = new ReminderNotification(new SMSChannel());
        reminder.sendNotification("Recordatorio: Tu cita con el médico es mañana a las 10:00 a.m.");

        // Cambiar el canal de recordatorio a push y enviar nuevamente
        reminder.setChannel(new PushNotificationChannel());
        reminder.sendNotification("Recordatorio: Tu cita con el médico es mañana a las 10:00 a.m.");

        // Crear una notificación de push usando el canal de notificación push
        PushNotification push = new PushNotification(new PushNotificationChannel());
        push.sendNotification("Nueva actualización disponible. Haz clic para instalar.");
    }
}
// Interface NOTIFICATION
interface NotificationChannel {
    void send(String message);
}

class EmailChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Enviando correo electrónico: " + message);
    }
}

class SMSChannel implements NotificationChannel {
    @Override
    public void send(String message) {
        System.out.println("Enviando SMS: " + message);
    }
}

class PushNotificationChannel implements NotificationChannel {

    @Override
    public void send(String message) {
        System.out.println("Enviando Push: " + message);
    }
}

// ABSTRACTION NOTIFICATION  dependency -> NOTIFICATION CHANNEL

abstract class Notification {
    protected NotificationChannel channel;

    public Notification(NotificationChannel channel) {
        this.channel = channel;
    }
    abstract void sendNotification(String message);
    abstract void setChannel(NotificationChannel channel);
}

class AlertNotification extends Notification{

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

class PushNotification extends Notification{
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

class ReminderNotification extends Notification{

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
