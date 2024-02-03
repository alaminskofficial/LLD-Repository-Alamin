package org.example.designpattern.factory;

import org.example.designpattern.factory.components.button.Button;
import org.example.designpattern.factory.components.button.IosButton;
import org.example.designpattern.factory.components.dropdown.Dropdown;
import org.example.designpattern.factory.components.dropdown.IosDropdown;
import org.example.designpattern.factory.components.menu.IosMenu;
import org.example.designpattern.factory.components.menu.Menu;

public class IosUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Menu createMenu() {
        return new IosMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new IosDropdown();
    }
}
