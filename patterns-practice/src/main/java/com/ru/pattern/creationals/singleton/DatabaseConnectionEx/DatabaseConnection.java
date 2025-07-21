package com.ru.pattern.creationals.singleton.DatabaseConnectionEx;
/**
 * ! Singleton:
 * Es un patrón de diseño creacional que garantiza que una clase
 * tenga una única instancia y proporciona un punto de acceso global a ella.
 *
 * * Es útil cuando necesitas controlar el acceso a una única instancia
 * * de una clase, como por ejemplo, en un objeto de base de datos o en un
 * * objeto de configuración.
 */

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private boolean connected;

    // Constructor privado para evitar instancias directas
    private DatabaseConnection() {
        this.connected = false;
    }

    // Método estático para obtener la instancia única
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Método para conectar a la base de datos
    public void connect() {
        if( connected){
            System.out.println( "Ya estaba conectado a la base de datos");
        }else {
            this.connected = true;
            System.out.println("Conectado a la base de datos");
        }
    }

    // Método para desconectar de la base de datos
    public void disconnect() {
        if( !connected){
            System.out.println( "No estaba conectado a la base de datos");
        }else{
            this.connected = false;
            System.out.println( "Desconectado de la base de datos");
        }
    }
}
