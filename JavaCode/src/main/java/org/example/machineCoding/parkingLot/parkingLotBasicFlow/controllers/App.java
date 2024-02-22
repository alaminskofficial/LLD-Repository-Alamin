package org.example.machineCoding.parkingLot.parkingLotBasicFlow.controllers;



import org.example.machineCoding.parkingLot.parkingLotBasicFlow.dtos.IssueTicketRequest;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.dtos.IssueTicketResponse;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.*;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.GateRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.ParkingLotRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.TicketRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories.VehicleRepository;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.services.TicketService;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.strategies.SimpleParkingSpotAllotmentStrategy;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        /*
          You need to create a parking lot first.

         */

        Gate gate = new Gate(1l, GateType.ENTRY, GateStatus.WORKING);

        Floor floor1 = new Floor(1);

        for(int i=1; i<=10; i++) {
            floor1.getParkingSpots().add(
                    new ParkingSpot(i, VehicleType.FOUR_WHEELER, ParkingSpotStatus.AVAILABLE, floor1));
        }

        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(floor1);
        ArrayList<Gate> gates = new ArrayList<>();
        gates.add(gate);

        ParkingLot parkingLot = new ParkingLot(1l, floors, gates, ParkingLotStatus.ACTIVE);


        GateRepository gateRepository = new GateRepository();
        gateRepository.getGates().put(1l, gate);

        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        parkingLotRepository.getParkingLotMap().put(1l, parkingLot);

        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService =
                new TicketService(gateRepository, vehicleRepository,
                        parkingLotRepository, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequest issueTicketRequest = new IssueTicketRequest(
                VehicleType.FOUR_WHEELER, "KA-45",
                "Alamin", 1l, 1l, new SimpleParkingSpotAllotmentStrategy());
        IssueTicketResponse ticketResponse = ticketController.issueTicket(issueTicketRequest);
        System.out.println(ticketResponse.toString());
    }
}
