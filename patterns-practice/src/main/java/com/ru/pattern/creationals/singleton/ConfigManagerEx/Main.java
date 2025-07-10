package com.ru.pattern.creationals.singleton.ConfigManagerEx;

public class Main {
    public static void main(String[] args) {
        ConfigManager configManager = ConfigManager.getInstance();

        configManager.setConfig("apiURL", "http://localhost:3000/api");
        configManager.setConfig("timeout", "5000");
        configManager.setConfig("apikey", "ABC123");

        System.out.println(configManager.getConfig("apiURL"));
        System.out.println(configManager.getConfig("timeout"));
        System.out.println(configManager.getConfig("apikey"));
    }
}