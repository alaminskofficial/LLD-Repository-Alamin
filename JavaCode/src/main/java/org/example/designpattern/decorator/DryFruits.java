package org.example.designpattern.decorator;

public class DryFruits  implements IceCreamEntity{
    private IceCreamEntity iceCreamEntity;

    public DryFruits(IceCreamEntity iceCreamEntity) {
        this.iceCreamEntity = iceCreamEntity;
    }

    @Override
    public int getCost() {
        return iceCreamEntity.getCost() + 19;
    }

    @Override
    public String getDescription() {
        return iceCreamEntity.getDescription() + "dry fruits ->";
    }
}
