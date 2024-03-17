package org.example.machineCoding.restaurentMgmtSystem.services;


import org.example.machineCoding.restaurentMgmtSystem.adapters.PaymentGatewayAdapter;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.InvalidBillException;
import org.example.machineCoding.restaurentMgmtSystem.models.Bill;
import org.example.machineCoding.restaurentMgmtSystem.models.Payment;
import org.example.machineCoding.restaurentMgmtSystem.repositories.BillRepository;

public class PaymentServiceImpl implements PaymentService{

    private BillRepository billRepository;
    private PaymentGatewayAdapter paymentGatewayAdapter;

    public PaymentServiceImpl(BillRepository billRepository, PaymentGatewayAdapter paymentGatewayAdapter) {
        this.billRepository = billRepository;
        this.paymentGatewayAdapter = paymentGatewayAdapter;
    }

    @Override
    public Payment makePayment(long billId) throws InvalidBillException {
        Bill bill = billRepository.findById(billId).orElseThrow(() -> new InvalidBillException("Bill not found"));
        return paymentGatewayAdapter.makePayment(billId, bill.getTotalAmount());
    }
}
