package org.example.machineCoding.parkingLot.parkingLotBasicFlow.controllers;


import org.example.machineCoding.parkingLot.parkingLotBasicFlow.dtos.IssueTicketRequest;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.dtos.IssueTicketResponse;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.GateNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.ParkingLotFullException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.ParkingLotNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.Ticket;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponse issueTicket(IssueTicketRequest request){
        Ticket ticket = null;
        try {
            ticket = ticketService.issueTicket(request);
        } catch (GateNotFoundException e) {
            System.out.println("Gate not found ");
            return new IssueTicketResponse(null, "FAILURE", "Invalid Gate");
        } catch (ParkingLotNotFoundException e) {
            System.out.println("Parking Log not found ");
            return new IssueTicketResponse(null, "FAILURE", "Invalid ParkingLot");
        } catch (ParkingLotFullException e) {
            System.out.println("Parking Log is full");
            return new IssueTicketResponse(null, "FAILURE", "ParkingLot FULL");
        }
        return new IssueTicketResponse(ticket, "SUCCESS", "Ticket Generated");
    }
}
