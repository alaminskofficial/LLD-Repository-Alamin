package org.example.machineCoding.parkingLot.parkingLotAssignment.respositories;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Invoice;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);
}
