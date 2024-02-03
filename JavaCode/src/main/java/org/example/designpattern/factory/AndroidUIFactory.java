package org.example.designpattern.factory;


import org.example.designpattern.factory.components.button.AndroidButton;
import org.example.designpattern.factory.components.button.Button;
import org.example.designpattern.factory.components.dropdown.AndroidDropdown;
import org.example.designpattern.factory.components.dropdown.Dropdown;
import org.example.designpattern.factory.components.menu.AndroidMenu;
import org.example.designpattern.factory.components.menu.Menu;

public class AndroidUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }
}
