package org.example.designpattern.decorator;

public class StrawBerryScoop implements IceCreamEntity{
    private IceCreamEntity iceCreamEntity;

    public StrawBerryScoop(IceCreamEntity iceCreamEntity) {
        this.iceCreamEntity = iceCreamEntity;
    }

    @Override
    public int getCost() {
        return iceCreamEntity.getCost() + 21;
    }

    @Override
    public String getDescription() {
        return iceCreamEntity.getDescription() + "straw berry scoop ->";
    }
}
