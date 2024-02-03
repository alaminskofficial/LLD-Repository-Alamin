package org.example.designpattern.factory;

import org.example.designpattern.factory.components.button.Button;
import org.example.designpattern.factory.components.button.WebButton;
import org.example.designpattern.factory.components.dropdown.Dropdown;
import org.example.designpattern.factory.components.dropdown.WebDropdown;
import org.example.designpattern.factory.components.menu.Menu;
import org.example.designpattern.factory.components.menu.WebMenu;

public class WebUiFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WebButton();
    }

    @Override
    public Menu createMenu() {
        return new WebMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new WebDropdown();
    }
}
