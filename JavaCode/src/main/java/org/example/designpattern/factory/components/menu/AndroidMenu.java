package org.example.designpattern.factory.components.menu;

public class AndroidMenu implements Menu{
    @Override
    public void getMenuList() {
        System.out.println("get the list of menu in android");
    }
}
