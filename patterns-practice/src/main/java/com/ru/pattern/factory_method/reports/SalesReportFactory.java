package com.ru.pattern.factory_method.reports;

public class SalesReportFactory extends ReportFactory{

    public Report getReport() {
        return new SalesReport();
    }

}
