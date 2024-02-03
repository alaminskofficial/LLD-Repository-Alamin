package org.example.designpattern.factory.components.button;

public class WebButton implements Button{
    @Override
    public void changeSize() {
        System.out.println("change the button in web");
    }
}
