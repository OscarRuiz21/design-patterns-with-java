package com.ru.pattern.creationals.factory_method.reports;

public class SalesReportFactory extends ReportFactory{

    public Report getReport() {
        return new SalesReport();
    }

}
