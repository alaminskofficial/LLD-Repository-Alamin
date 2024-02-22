package org.example.machineCoding.parkingLot.parkingLotAssignment.dtos;


import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Ticket;

public class GenerateTicketResponseDto {

    private Ticket ticket;
    private ResponseStatus responseStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
