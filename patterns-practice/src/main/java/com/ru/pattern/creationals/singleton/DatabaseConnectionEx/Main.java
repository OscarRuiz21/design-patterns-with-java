package com.ru.pattern.creationals.singleton.DatabaseConnectionEx;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.connect(); // Debería conectar a la base de datos

        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.connect(); // Debería mostrar que ya existe una conexión activa

        System.out.println("Son iguales: " + (db1 == db2)); // Debería mostrar true

        db1.disconnect(); // Debería cerrar la conexión

        db2.connect(); // Ahora debería conectar de nuevo, ya que se cerró la anterior
    }
}