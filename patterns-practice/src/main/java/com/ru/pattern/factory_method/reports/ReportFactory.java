package com.ru.pattern.factory_method.reports;

public abstract class ReportFactory {

    public abstract Report getReport();

    public void generateReport() {
        Report report = getReport();
        report.generate();
    }
}
