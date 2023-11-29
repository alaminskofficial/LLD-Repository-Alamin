package org.example.designpattern.decorator;

public class OrangeCone implements  IceCreamEntity{
    private IceCreamEntity iceCreamEntity;
    public OrangeCone(){}

    public OrangeCone(IceCreamEntity iceCreamEntity) {
        this.iceCreamEntity = iceCreamEntity;
    }

    @Override
    public int getCost() {
        if(iceCreamEntity != null){
            return iceCreamEntity.getCost() + 10;
        }
        return 10;
    }

    @Override
    public String getDescription() {
        if(iceCreamEntity != null){
            return iceCreamEntity.getDescription() + "Orange Cone ->";
        }
        return "Orange Cone ->";
    }
}
