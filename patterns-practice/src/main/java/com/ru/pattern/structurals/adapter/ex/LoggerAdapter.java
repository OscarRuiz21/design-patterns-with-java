package com.ru.pattern.structurals.adapter.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerAdapter implements ILoggerAdapter {

    String file;

    private static final Logger logger = LoggerFactory.getLogger(Adapter.class);


    public LoggerAdapter(String file) {
        this.file = file;
    }

    @Override
    public void writeLog(String message) {
        logger.info("[" + file + "Log]" + message);

    }

    @Override
    public void writeError(String message) {
        logger.error("[" + file + "Error]" + ANSI_RED +message + ANSI_RESET);

    }

    @Override
    public void writeWarning(String message) {
        logger.warn("[" + file + "Warning]" + ANSI_YELLOW +message + ANSI_RESET);
    }

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";

}
