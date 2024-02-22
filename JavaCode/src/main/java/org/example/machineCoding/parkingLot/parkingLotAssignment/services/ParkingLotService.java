package org.example.machineCoding.parkingLot.parkingLotAssignment.services;

import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.InvalidParkingLotException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.ParkingFloor;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;

import java.util.List;
import java.util.Map;

public interface ParkingLotService {
    public Map<ParkingFloor, Map<String, Integer>> getParkingLotCapacity(long parkingLotId, List<Long> parkingFloors, List<VehicleType> vehicleTypes) throws InvalidParkingLotException, InvalidParkingLotException;
}
