package org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories;





import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.Ticket;

import java.util.HashMap;
import java.util.Map;


public class TicketRepository {

    private Map<String, Ticket> ticketMap = new HashMap<>();

    public Map<String, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<String, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }

    public void save(Ticket ticket){
        ticketMap.put(ticket.getNumber(), ticket);
    }
}
