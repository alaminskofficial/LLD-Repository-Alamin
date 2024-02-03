package org.example.designpattern.factory;
//@Author : Sk Alamin
import org.example.designpattern.factory.components.button.Button;
import org.example.designpattern.factory.components.dropdown.Dropdown;
import org.example.designpattern.factory.components.menu.Menu;

public class Client {
    public static void main(String[] args) {
        ReactNative reactNative = new ReactNative(SupportedPlatforms.WEB);
        UIFactory uiFactory = reactNative.getUIFactory();
        Button button = uiFactory.createButton();
        button.changeSize();
        Menu menu = uiFactory.createMenu();
        menu.getMenuList();
        Dropdown dropdown = uiFactory.createDropdown();
        dropdown.getDropdown();
    }
}
