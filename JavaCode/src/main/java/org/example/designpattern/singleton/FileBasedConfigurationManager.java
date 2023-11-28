package org.example.designpattern.singleton;

import java.util.Properties;

public abstract class FileBasedConfigurationManager {
   // public abstract FileBasedConfigurationManager getInstance();

    public abstract void resetInstance();
    protected abstract Properties loadConfigurationFromFile(String filePath);

    protected abstract void saveConfigurationToFile(Properties properties, String filePath);

    public abstract String getConfiguration(String key);

    public abstract <T> T getConfiguration(String key, Class<T> type);

    public abstract void setConfiguration(String key, String value);

    public abstract <T> void setConfiguration(String key, T value);

    public abstract void removeConfiguration(String key);

    public abstract void clear();
}
