package org.example.designpattern.factory.components.button;

public class AndroidButton implements Button{
    @Override
    public void changeSize() {
        System.out.println("change the button size in android ::");
    }
}
