package org.example.designpattern.decorator;

public class ChocholateCone implements  IceCreamEntity{
    private IceCreamEntity iceCreamEntity;

    public ChocholateCone() {}

    public ChocholateCone(IceCreamEntity iceCreamEntity) {
        this.iceCreamEntity = iceCreamEntity;
    }

    @Override
    public int getCost() {
        if(iceCreamEntity != null){
            return iceCreamEntity.getCost() + 17;
        }
        return 17;
    }

    @Override
    public String getDescription() {
        if(iceCreamEntity != null){
            return iceCreamEntity.getDescription() + "Chocolate Cone ->";
        }
        return "Chocolate Cone ->";
    }
}
