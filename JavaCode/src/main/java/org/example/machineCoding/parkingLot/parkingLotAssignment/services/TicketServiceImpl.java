package org.example.machineCoding.parkingLot.parkingLotAssignment.services;

import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.*;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.*;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.GateRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.ParkingLotRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.TicketRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.VehicleRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.assignment.SpotAssignmentStrategy;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    public Ticket generateTicket(long gateId, String registrationNumber, String vehicleType, List<String> additionalServicesList) throws InvalidGateException, InvalidParkingLotException, ParkingSpotNotAvailableException, UnsupportedAdditionalService, AdditionalServiceNotSupportedByVehicle {
        List<AdditionalService> additionalServices = new ArrayList<>();
        if(additionalServicesList != null) {
            for (String additionalServiceStr : additionalServicesList) {
                AdditionalService additionalService;
                try {
                    additionalService = AdditionalService.valueOf(additionalServiceStr);
                } catch (IllegalArgumentException e) {
                    throw new UnsupportedAdditionalService("Invalid additional service. plz check the notice board.. ");
                }
                if (!additionalService.getSupportedVehicleTypes().contains(VehicleType.valueOf(vehicleType))) {
                    throw new AdditionalServiceNotSupportedByVehicle("Invalid vehicle type for additional service");
                }
                additionalServices.add(additionalService);
            }
        }
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
        ticket.setAdditionalServices(additionalServices);
        return this.ticketRepository.save(ticket);
    }

}