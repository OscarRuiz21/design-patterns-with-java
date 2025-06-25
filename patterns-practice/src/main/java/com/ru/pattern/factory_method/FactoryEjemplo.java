package com.ru.pattern.factory_method;

import com.ru.pattern.factory_method.reports.InventoryReportFactory;
import com.ru.pattern.factory_method.reports.ReportFactory;
import com.ru.pattern.factory_method.reports.SalesReportFactory;
import com.ru.pattern.factory_method.restaurant_example.BeefRestaurant;
import com.ru.pattern.factory_method.restaurant_example.ChickenRestaurant;
import com.ru.pattern.factory_method.restaurant_example.Restaurant;

import java.util.Scanner;

/**
 * ! Factory Method:
 * El patrón Factory Method permite crear objetos sin especificar
 * la clase exacta del objeto que se creará.
 *
 * En lugar de eso, delegamos la creación de objetos a subclases o métodos
 * que encapsulan esta lógica.
 *
 * * Es útil cuando una clase no puede anticipar la clase
 * * de objetos que debe crear.
 *
 * https://refactoring.guru/es/design-patterns/factory-method
 *
 */
public class FactoryEjemplo {
    public static void main(String[] args) {

        try (Scanner sn = new Scanner(System.in)) {
        Restaurant restaurant;

        System.out.println("Ingrese el tipo de hamburguesa que desea: (chicken o beef)");
            String burgerType = sn.nextLine();
            restaurant = switch (burgerType) {
                case "chicken" -> new ChickenRestaurant();
                case "beef" -> new BeefRestaurant();
                default -> throw new IllegalArgumentException("Tipo de hamburguesa no reconocido");
            };
            restaurant.orderBurger();


        ReportFactory reportFactory;


        System.out.println("Ingrese el tipo de reporte que desea: (sales o inventory)");
            String reportType = sn.nextLine();
            reportFactory = switch (reportType) {
                case "sales" -> new SalesReportFactory();
                case "inventory" -> new InventoryReportFactory();
                default -> throw new IllegalArgumentException("Tipo de reporte no reconocido");
            };
            reportFactory.generateReport();
        }

    }
}
