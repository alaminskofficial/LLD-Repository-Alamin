package org.example.machineCoding.parkingLotAssignment.services;

import org.example.machineCoding.parkingLotAssignment.exceptions.InvalidGateException;
import org.example.machineCoding.parkingLotAssignment.exceptions.InvalidParkingLotException;
import org.example.machineCoding.parkingLotAssignment.exceptions.ParkingSpotNotAvailableException;
import org.example.machineCoding.parkingLotAssignment.models.Ticket;

public interface TicketService {
    // Do not modify the method signatures, feel free to add new methods
    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleType) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException;
}
