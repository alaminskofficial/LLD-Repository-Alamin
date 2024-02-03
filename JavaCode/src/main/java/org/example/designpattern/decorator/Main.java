package org.example.designpattern.decorator;
//@Author : Sk Alamin
public class Main {
    public static void main(String[] args) {
        IceCreamEntity iceCream =
                new DryFruits(
                        new VanillaScoop(
                                new StrawBerryScoop(
                                        new Chocochips(
                                                new ChocholateCone(
                                                        new ChocholateCone(
                                                                new OrangeCone()
                                                        )
                                                )
                                        )
                                )
                        )
                );

        System.out.println(iceCream.getDescription());
        System.out.println(iceCream.getCost());
    }
}
