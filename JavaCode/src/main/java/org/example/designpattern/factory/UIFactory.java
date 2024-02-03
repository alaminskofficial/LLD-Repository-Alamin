package org.example.designpattern.factory;

import org.example.designpattern.factory.components.button.Button;
import org.example.designpattern.factory.components.dropdown.Dropdown;
import org.example.designpattern.factory.components.menu.Menu;

public interface UIFactory {
    public Button createButton();
    public Menu createMenu();
    public Dropdown createDropdown();
}
