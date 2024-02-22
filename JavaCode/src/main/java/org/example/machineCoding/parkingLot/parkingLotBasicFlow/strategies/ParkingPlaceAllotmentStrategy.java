package org.example.machineCoding.parkingLot.parkingLotBasicFlow.strategies;


import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.ParkingLotFullException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.ParkingLot;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.ParkingSpot;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.VehicleType;

public interface ParkingPlaceAllotmentStrategy {

    ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException;
}
