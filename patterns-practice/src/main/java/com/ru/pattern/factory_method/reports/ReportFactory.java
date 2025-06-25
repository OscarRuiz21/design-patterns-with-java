package com.ru.pattern.factory_method.reports;

public abstract class ReportFactory {

    protected abstract Report getReport();

    public void generateReport() {
        Report report = getReport();
        report.generate();
    }
}
