package org.example.designpattern.decorator;

public class Chocochips implements IceCreamEntity{
    private IceCreamEntity iceCreamEntity;

    public Chocochips(IceCreamEntity iceCreamEntity) {
        this.iceCreamEntity = iceCreamEntity;
    }

    @Override
    public int getCost() {
        return iceCreamEntity.getCost() + 18;
    }

    @Override
    public String getDescription() {
        return iceCreamEntity.getDescription() + "Choco Chips ->";
    }
}
