package org.example.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigurationManager extends FileBasedConfigurationManager {
    private static ConfigurationManager instance;
    private Properties configurationProperties;
    private static final String CONFIG_FILE_PATH = "C:\\Users\\alamin\\Desktop\\config.properties";

    private ConfigurationManager() {
        this.configurationProperties = loadConfigurationFromFile(CONFIG_FILE_PATH);
    }

    public static FileBasedConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (FileBasedConfigurationManager.class) {
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    @Override
    public void resetInstance() {
        instance = null;
    }

    @Override
    protected Properties loadConfigurationFromFile(String filePath) {
        Properties properties = new Properties();
        try(InputStream inputStream = new FileInputStream(filePath)){
           properties.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }

    @Override
    protected void saveConfigurationToFile(Properties properties, String filePath) {
        try(OutputStream output = new FileOutputStream(filePath)){
            properties.store(output , "saved the config data");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getConfiguration(String key) {
        return configurationProperties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = configurationProperties.getProperty(key);
        if (value != null) {
            return convertConfigValue(value, type);
        }
        return null;
    }

    private <T> T convertConfigValue(String value, Class<T> type) {
        if (type.equals(String.class)) {
            return type.cast(value);
        } else if (type.equals(Integer.class) || type.equals(int.class)) {
            return type.cast(Integer.parseInt(value));
        } else if (type.equals(Double.class) || type.equals(double.class)) {
            return type.cast(Double.parseDouble(value));
        } else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
            return type.cast(Boolean.parseBoolean(value));
        } else {
            throw new IllegalArgumentException("Unsupported conversion type: " + type.getSimpleName());
        }
    }

    @Override
    public void setConfiguration(String key, String value) {
        configurationProperties.setProperty(key, value);
        saveConfigurationToFile(configurationProperties, CONFIG_FILE_PATH);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        if (value != null) {
            setConfiguration(key, value.toString());
        }else{
            removeConfiguration(key);
        }
    }

    @Override
    public void removeConfiguration(String key) {
        configurationProperties.remove(key);
        saveConfigurationToFile(configurationProperties, CONFIG_FILE_PATH);
    }

    @Override
    public void clear() {
        configurationProperties.clear();
        saveConfigurationToFile(configurationProperties, CONFIG_FILE_PATH);
    }
}
