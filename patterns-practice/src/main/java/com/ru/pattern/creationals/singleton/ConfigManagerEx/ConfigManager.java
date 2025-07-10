package com.ru.pattern.creationals.singleton.ConfigManagerEx;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private final Map<String, String> config = new HashMap<>();

    // Singleton instance
    private static final ConfigManager instance = new ConfigManager();

    // Private constructor to prevent external instantiation
    private ConfigManager() {}

    // Public method to access the singleton instance
    public static ConfigManager getInstance() {
        return instance;
    }

    public void setConfig(String key, String value) {
        config.put(key, value);
    }

    public String getConfig(String key) {
        return config.getOrDefault(key, null);
    }

    public Map<String, String> getAllConfig() {
        return Collections.unmodifiableMap(config); // immutable copy
    }
}
