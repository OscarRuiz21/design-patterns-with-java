package com.ru.pattern.factory_method.reports;

public class InventoryReportFactory extends ReportFactory {

    public Report getReport() {
        return new InventoryReport();
    }
}
