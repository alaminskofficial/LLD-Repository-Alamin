package org.example.machineCoding.parkingLot.parkingLotAssignment.controllers;

import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.GenerateInvoiceRequestDto;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.GenerateInvoiceResponseDto;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.ResponseStatus;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Invoice;
import org.example.machineCoding.parkingLot.parkingLotAssignment.services.InvoiceService;

public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public static void main(String[] args) {

    }
    public GenerateInvoiceResponseDto createInvoice(GenerateInvoiceRequestDto requestDto){
        GenerateInvoiceResponseDto responseDto = new GenerateInvoiceResponseDto();
        try {
            Invoice invoice = invoiceService.createInvoice(requestDto.getTicketId(), requestDto.getGateId());
            responseDto.setStatus(ResponseStatus.SUCCESS);
            responseDto.setInvoice(invoice);
            return responseDto;
        } catch (Exception e){
            responseDto.setStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
}
