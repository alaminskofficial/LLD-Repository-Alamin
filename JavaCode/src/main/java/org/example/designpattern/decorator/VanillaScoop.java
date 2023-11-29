package org.example.designpattern.decorator;

public class VanillaScoop implements IceCreamEntity{
    private IceCreamEntity iceCreamEntity;

    public VanillaScoop(IceCreamEntity iceCreamEntity) {
        this.iceCreamEntity = iceCreamEntity;
    }

    @Override
    public int getCost() {
        return iceCreamEntity.getCost() + 14;
    }

    @Override
    public String getDescription() {
        return iceCreamEntity.getDescription() + "vanilla scoop ->";
    }
}
