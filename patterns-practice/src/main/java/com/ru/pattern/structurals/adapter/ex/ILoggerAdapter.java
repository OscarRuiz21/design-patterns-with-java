package com.ru.pattern.structurals.adapter.ex;

public interface ILoggerAdapter {

    String file = "";

    public void writeLog(String message);
    public void writeError(String message);
    public void writeWarning(String message);

}
