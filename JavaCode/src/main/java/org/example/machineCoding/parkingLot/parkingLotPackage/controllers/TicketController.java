package org.example.machineCoding.parkingLot.controllers;


import org.example.machineCoding.parkingLot.dtos.*;
import org.example.machineCoding.parkingLot.exceptions.GateNotFoundException;
import org.example.machineCoding.parkingLot.exceptions.ParkingLotFullException;
import org.example.machineCoding.parkingLot.exceptions.ParkingLotNotFoundException;
import org.example.machineCoding.parkingLot.models.Ticket;
import org.example.machineCoding.parkingLot.services.TicketService;

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
