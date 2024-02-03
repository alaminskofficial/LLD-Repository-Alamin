package org.example.designpattern.factory.components.menu;

public class IosMenu implements Menu{
    @Override
    public void getMenuList() {
        System.out.println("get the menu list in ios");
    }
}
