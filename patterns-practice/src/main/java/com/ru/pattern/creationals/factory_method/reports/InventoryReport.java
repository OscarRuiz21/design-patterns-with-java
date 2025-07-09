package com.ru.pattern.creationals.factory_method.reports;

public class InventoryReport implements Report{

    @Override
    public void generate() {
        System.out.println("Generating inventory report");
    }

}
