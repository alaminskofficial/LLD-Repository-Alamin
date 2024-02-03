package org.example.designpattern.factory.components.button;

public class IosButton implements Button{
    @Override
    public void changeSize() {
        System.out.println("change the size in IOS");
    }
}
