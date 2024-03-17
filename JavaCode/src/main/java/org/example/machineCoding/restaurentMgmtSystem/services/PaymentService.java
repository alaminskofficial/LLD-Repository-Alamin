package org.example.machineCoding.restaurentMgmtSystem.services;


import org.example.machineCoding.restaurentMgmtSystem.exceptions.InvalidBillException;
import org.example.machineCoding.restaurentMgmtSystem.models.Payment;

public interface PaymentService {
    Payment makePayment(long billId) throws InvalidBillException;
}
