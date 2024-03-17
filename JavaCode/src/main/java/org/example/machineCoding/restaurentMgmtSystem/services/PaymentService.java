package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.Payment;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.InvalidBillException;

public interface PaymentService {
    Payment makePayment(long billId) throws InvalidBillException;
}
