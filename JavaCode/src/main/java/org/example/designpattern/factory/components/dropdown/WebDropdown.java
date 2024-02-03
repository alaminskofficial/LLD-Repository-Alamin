package org.example.designpattern.factory.components.dropdown;

public class WebDropdown implements Dropdown{
    @Override
    public void getDropdown() {
        System.out.println("get the dropdown in web");
    }
}
