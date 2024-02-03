package org.example.designpattern.singleton;
//@Author : Sk Alamin
public class Client {
    public static void main(String[] args) {
        FileBasedConfigurationManager configManager = ConfigurationManager.getInstance();
//        String value = configManager.getConfiguration("integerKey");
//        System.out.println("Value for key 'key': " + value);
//        configManager.removeConfiguration("integerKey");
//        configManager.setConfiguration("integerKey" , 96);
        String convertedValue = configManager.getConfiguration("integerKey", String.class);
        System.out.println(convertedValue);
    }
}
