package org.example.machineCoding.parkingLot.parkingLotAssignment.models;

import java.util.List;

public enum AdditionalService {
    CAR_WASH(List.of(VehicleType.CAR, VehicleType.SUV), 200),

    BIKE_WASH(List.of(VehicleType.EV_BIKE, VehicleType.BIKE), 100),

    CAR_DETAILING(List.of(VehicleType.CAR, VehicleType.SUV), 500),
    EV_BIKE_CHARGING(List.of(VehicleType.EV_BIKE), 100),
    EV_CAR_CHARGING(List.of(VehicleType.EV_CAR), 200);

    AdditionalService(List<VehicleType> supportedVehicleTypes, double cost) {
        this.supportedVehicleTypes = supportedVehicleTypes;
        this.cost = cost;
    }

    private final List<VehicleType> supportedVehicleTypes;
    private final double cost;

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public double getCost() {
        return cost;
    }
}

