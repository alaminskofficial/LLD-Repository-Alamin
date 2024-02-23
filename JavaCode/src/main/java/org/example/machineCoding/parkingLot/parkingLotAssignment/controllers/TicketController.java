package org.example.machineCoding.parkingLot.parkingLotAssignment.controllers;


import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.GenerateTicketRequestDto;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.GenerateTicketResponseDto;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.ResponseStatus;
import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.AdditionalServiceNotSupportedByVehicle;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Ticket;
import org.example.machineCoding.parkingLot.parkingLotAssignment.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        try{
            Ticket ticket = ticketService.generateTicket(Long.valueOf(requestDto.getGateId()), requestDto.getRegistrationNumber(), requestDto.getVehicleType(),requestDto.getAdditionalServices());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setTicket(ticket);
        } catch (Exception | AdditionalServiceNotSupportedByVehicle e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
