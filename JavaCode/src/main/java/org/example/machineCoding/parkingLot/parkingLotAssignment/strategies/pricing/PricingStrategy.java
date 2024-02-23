package org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.pricing;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;

import java.util.Date;

public interface PricingStrategy {
    double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType);
}