package org.example.designpattern.factory;

public class UiFactoryFactory {
    public static UIFactory getUIFactoryByPlatform(SupportedPlatforms platform){
        return switch(platform){
            case IOS -> new IosUIFactory();
            case ANDROID -> new AndroidUIFactory();
            case WEB ->  new WebUiFactory();
        };
    }
}
