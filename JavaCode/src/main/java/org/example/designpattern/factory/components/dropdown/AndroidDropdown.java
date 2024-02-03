package org.example.designpattern.factory.components.dropdown;

import org.example.designpattern.factory.components.button.Button;

public class AndroidDropdown implements Dropdown {

    @Override
    public void getDropdown() {
        System.out.println("get the dropdown  in android ");
    }
}
