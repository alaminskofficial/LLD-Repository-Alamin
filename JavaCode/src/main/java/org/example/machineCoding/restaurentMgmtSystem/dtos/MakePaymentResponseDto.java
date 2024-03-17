package org.example.machineCoding.restaurentMgmtSystem.dtos;

import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.PaymentStatus;

public class MakePaymentResponseDto {
    private ResponseStatus responseStatus;
    private String txnId;
    private PaymentStatus paymentStatus;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
