package org.example.machineCoding.restaurentMgmtSystem.controllers;

import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.Payment;
import org.example.machineCoding.restaurentMgmtSystem.dtos.MakePaymentRequestDto;
import org.example.machineCoding.restaurentMgmtSystem.dtos.MakePaymentResponseDto;
import org.example.machineCoding.restaurentMgmtSystem.dtos.ResponseStatus;
import org.example.machineCoding.restaurentMgmtSystem.services.PaymentService;

public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto) {
        MakePaymentResponseDto makePaymentResponseDto = new MakePaymentResponseDto();
        try{
            Payment payment = paymentService.makePayment(makePaymentRequestDto.getBillId());
            makePaymentResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            makePaymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
            makePaymentResponseDto.setTxnId(payment.getTxnId());
            return makePaymentResponseDto;
        } catch (Exception e) {
            makePaymentResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return makePaymentResponseDto;
        }
    }
}
