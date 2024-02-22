package org.example.machineCoding.parkingLot.strategies;


import org.example.machineCoding.parkingLot.exceptions.ParkingLotFullException;
import org.example.machineCoding.parkingLot.models.ParkingLot;
import org.example.machineCoding.parkingLot.models.ParkingSpot;
import org.example.machineCoding.parkingLot.models.VehicleType;

public interface ParkingPlaceAllotmentStrategy {

    ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException;
}
