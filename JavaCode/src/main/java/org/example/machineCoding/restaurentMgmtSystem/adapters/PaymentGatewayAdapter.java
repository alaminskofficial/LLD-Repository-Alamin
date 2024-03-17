package org.example.machineCoding.restaurentMgmtSystem.adapters;

import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.Payment;

public interface PaymentGatewayAdapter {

    Payment makePayment(long billId, double amount);
}
