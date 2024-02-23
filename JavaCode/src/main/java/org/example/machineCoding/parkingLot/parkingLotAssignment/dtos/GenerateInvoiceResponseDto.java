package org.example.machineCoding.parkingLot.parkingLotAssignment.dtos;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Invoice;

public class GenerateInvoiceResponseDto {
    private ResponseStatus status;
    private Invoice invoice;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
