package com.ru.pattern.factory_method.reports;

public class SalesReport implements Report {
    @Override
    public void generate() {
        System.out.println("Generating sales report");
    }
}
