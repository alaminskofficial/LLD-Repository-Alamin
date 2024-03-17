package org.example.machineCoding.restaurentMgmtSystem.adapters;

import org.example.machineCoding.restaurentMgmtSystem.libraries.paytm.PaytmApi;
import org.example.machineCoding.restaurentMgmtSystem.libraries.paytm.PaytmPaymentResponse;
import org.example.machineCoding.restaurentMgmtSystem.models.Payment;
import org.example.machineCoding.restaurentMgmtSystem.models.PaymentStatus;

public class PaytmAdaptor implements PaymentGatewayAdapter{
    private PaytmApi paytmApi;

    public PaytmAdaptor(PaytmApi paytmApi) {
        this.paytmApi = paytmApi;
    }

    @Override
    public Payment makePayment(long billId, double amount) {
        PaytmPaymentResponse paytmPaymentResponse = paytmApi.makePayment(billId, amount);
        Payment payment = new Payment();
        payment.setTxnId(paytmPaymentResponse.getTxnId());
        payment.setPaymentStatus(PaymentStatus.valueOf(paytmPaymentResponse.getPaymentStatus()));
        payment.setBillId(billId);
        return payment;
    }
}
