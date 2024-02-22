package org.example.machineCoding.parkingLot.parkingLotBasicFlow.models;

public class Vehicle {

    private String number;
    private VehicleType type;
    private String ownerName;

    public Vehicle(String number, VehicleType type, String ownerName) {
        this.number = number;
        this.type = type;
        this.ownerName = ownerName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
