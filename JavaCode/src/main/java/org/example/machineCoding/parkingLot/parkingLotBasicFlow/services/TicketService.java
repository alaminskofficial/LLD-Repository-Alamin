package org.example.machineCoding.parkingLot.parkingLotBasicFlow.services;




import org.example.machineCoding.parkingLot.parkingLotBasicFlow.dtos.IssueTicketRequest;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.GateNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.ParkingLotFullException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.ParkingLotNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.*;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.GateRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.ParkingLotRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.TicketRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.VehicleRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.strategies.ParkingPlaceAllotmentStrategy;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(IssueTicketRequest request) throws GateNotFoundException,
            ParkingLotNotFoundException, ParkingLotFullException {

        /*
            1. SET TIME
            2. GET VEHICLE AND GATE DETAILS
            3. GET PARKING LOT
               Assign an empty spot for this vehicle.
            4. GENERATE TICKET NUMBER
            5. SAVE AND RETURN THE TICKET
         */

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.findGateById(request.getGateId());
        ticket.setGate(gate);

        Vehicle vehicle = vehicleRepository.getVehicleByNumber(request.getVehicleNumber());
        if(vehicle==null){
            vehicle = new Vehicle(request.getVehicleNumber(), request.getVehicleType(), request.getOwner());
            vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(vehicle);

        ParkingLot parkingLot = parkingLotRepository.getParkingLotById(request.getParkingLotId());

        ParkingPlaceAllotmentStrategy allotmentStrategy = request.getParkingPlaceAllotmentStrategy();

        ParkingSpot parkingSpot =
                allotmentStrategy.getParkingSpot(request.getVehicleType(), parkingLot);

        ticket.setParkingSpot(parkingSpot);
        ticket.setNumber(request.getVehicleNumber()+ UUID.randomUUID());

        ticketRepository.save(ticket);

        return ticket;
    }
}
