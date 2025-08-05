package com.ru.pattern.structurals.bridge.hw;

public class Main {
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
