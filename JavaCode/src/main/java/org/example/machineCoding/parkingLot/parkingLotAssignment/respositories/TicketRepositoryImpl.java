package org.example.machineCoding.parkingLot.parkingLotAssignment.respositories;


import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Ticket;

import java.util.*;

public class TicketRepositoryImpl implements TicketRepository {

    private final List<Ticket> ticketList = new ArrayList<>();
    @Override
    public Ticket save(Ticket ticket) {
        ticketList.add(ticket);
        return ticket;
    }

    @Override
    public Optional<Ticket> getTicketById(long ticketId) {
        for(Ticket ticket:ticketList){
            if(ticket.getId()==ticketId){
                return Optional.of(ticket);
            }
        }
        return Optional.empty();
    }
}