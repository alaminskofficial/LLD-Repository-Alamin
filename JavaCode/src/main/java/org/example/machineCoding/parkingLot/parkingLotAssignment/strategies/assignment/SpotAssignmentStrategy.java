package org.example.machineCoding.parkingLotAssignment.strategies.assignment;

import org.example.machineCoding.parkingLotAssignment.models.ParkingLot;
import org.example.machineCoding.parkingLotAssignment.models.ParkingSpot;
import org.example.machineCoding.parkingLotAssignment.models.VehicleType;

import java.util.Optional;

public interface SpotAssignmentStrategy {

    Optional<ParkingSpot> assignSpot(ParkingLot parkingLot, VehicleType vehicleType);

}