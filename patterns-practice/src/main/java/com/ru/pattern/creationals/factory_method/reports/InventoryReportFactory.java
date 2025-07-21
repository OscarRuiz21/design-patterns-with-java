package com.ru.pattern.creationals.factory_method.reports;

public class InventoryReportFactory extends ReportFactory {

    public Report getReport() {
        return new InventoryReport();
    }
}
