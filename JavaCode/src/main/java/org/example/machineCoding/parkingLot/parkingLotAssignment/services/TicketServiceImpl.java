package org.example.machineCoding.parkingLotAssignment.services;

import org.example.machineCoding.parkingLotAssignment.exceptions.InvalidParkingLotException;
import org.example.machineCoding.parkingLotAssignment.exceptions.ParkingSpotNotAvailableException;
import org.example.machineCoding.parkingLotAssignment.exceptions.InvalidGateException;
import org.example.machineCoding.parkingLotAssignment.models.*;
import org.example.machineCoding.parkingLotAssignment.respositories.GateRepository;
import org.example.machineCoding.parkingLotAssignment.respositories.TicketRepository;
import org.example.machineCoding.parkingLotAssignment.respositories.VehicleRepository;
import org.example.machineCoding.parkingLotAssignment.strategies.assignment.SpotAssignmentStrategy;
import org.example.machineCoding.parkingLotAssignment.respositories.ParkingLotRepository;

import java.util.Date;
import java.util.Optional;

public class TicketServiceImpl implements TicketService{
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    public TicketServiceImpl(GateRepository gateRepository, VehicleRepository vehicleRepository, SpotAssignmentStrategy spotAssignmentStrategy, ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket generateTicket(int gateId, String registrationNumber, String vehicleType) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException {
        Optional<Gate> optionalGate = this.gateRepository.findById(gateId);
        if (optionalGate.isEmpty()) {
            throw new InvalidGateException("Invalid gate id");
        }
        Gate gate = optionalGate.get();
        if(gate.getType().equals(GateType.EXIT)) {
            throw new InvalidGateException("Vehicle trying to enter from exit gate");
        }

        Vehicle vehicle;
        Optional<Vehicle> optionalVehicle = vehicleRepository.getVehicleByRegistrationNumber(registrationNumber);
        if (optionalVehicle.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setRegistrationNumber(registrationNumber);
            vehicle.setVehicleType(VehicleType.valueOf(vehicleType));
            vehicle = vehicleRepository.save(vehicle);
        } else {
            vehicle = optionalVehicle.get();
        }

        Optional<ParkingLot> parkingLotOptional = this.parkingLotRepository.getParkingLotByGateId(gateId);
        if (parkingLotOptional.isEmpty()) {
            throw new InvalidParkingLotException("Invalid parking lot id");
        }
        ParkingLot parkingLot = parkingLotOptional.get();

        Optional<ParkingSpot> parkingSpotOptional = spotAssignmentStrategy.assignSpot(parkingLot, VehicleType.valueOf(vehicleType));
        if (parkingSpotOptional.isEmpty()) {
            throw new ParkingSpotNotAvailableException("No parking spot available");
        }
        ParkingSpot parkingSpot = parkingSpotOptional.get();

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setParkingSpot(parkingSpot);
        ticket.setGate(gate);
        ticket.setParkingAttendant(gate.getParkingAttendant());
        return this.ticketRepository.save(ticket);
    }
}
