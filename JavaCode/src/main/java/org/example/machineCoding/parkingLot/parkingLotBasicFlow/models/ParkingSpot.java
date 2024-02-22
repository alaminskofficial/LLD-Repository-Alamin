package org.example.machineCoding.parkingLot.parkingLotBasicFlow.models;

public class ParkingSpot {

    private int number;
    private VehicleType vehicleType;
    private ParkingSpotStatus status;
    private Floor floor;

    public ParkingSpot(int number, VehicleType vehicleType, ParkingSpotStatus status, Floor floor) {
        this.number = number;
        this.vehicleType = vehicleType;
        this.status = status;
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }
}
