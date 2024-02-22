package org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.assignment;


import org.example.machineCoding.parkingLot.parkingLotAssignment.models.ParkingLot;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.ParkingSpot;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {

    Optional<ParkingSpot> assignSpot(ParkingLot parkingLot, VehicleType vehicleType);

}