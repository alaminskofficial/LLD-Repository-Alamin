package org.example.machineCoding.parkingLot.parkingLotAssignment.services;


import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.*;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Ticket;

import java.util.List;

public interface TicketService {

    // Do not modify the method signatures, feel free to add new methods
    public Ticket generateTicket(long gateId, String registrationNumber, String vehicleType , List<String> additionalServices) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException, UnsupportedAdditionalService, AdditionalServiceNotSupportedByVehicle;
}
