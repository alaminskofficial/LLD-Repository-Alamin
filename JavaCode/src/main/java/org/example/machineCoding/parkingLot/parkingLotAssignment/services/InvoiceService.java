package org.example.machineCoding.parkingLot.parkingLotAssignment.services;

import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.InvalidGateException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.TicketNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Invoice;

public interface InvoiceService {
    public Invoice createInvoice(long ticketId, long gateId) throws TicketNotFoundException, InvalidGateException;
}

