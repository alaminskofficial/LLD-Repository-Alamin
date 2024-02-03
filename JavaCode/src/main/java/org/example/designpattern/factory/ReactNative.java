package org.example.designpattern.factory;

public class ReactNative {
    SupportedPlatforms platforms;
    public ReactNative (SupportedPlatforms platforms){
        this.platforms = platforms;
    }
    public void setTheme(){
        System.out.println("Setting Theme...");
    }

    public void setRefreshRate(){
        System.out.println("Setting refresh rate to 120Hz...");
    }
    public UIFactory getUIFactory(){
        return UiFactoryFactory.getUIFactoryByPlatform(this.platforms);
    }
}
