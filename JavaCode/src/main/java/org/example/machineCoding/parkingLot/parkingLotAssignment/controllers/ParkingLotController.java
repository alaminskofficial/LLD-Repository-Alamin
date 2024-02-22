package org.example.machineCoding.parkingLot.parkingLotAssignment.controllers;

import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.GetParkingLotCapacityRequestDto;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.GetParkingLotCapacityResponseDto;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.Response;
import org.example.machineCoding.parkingLot.parkingLotAssignment.dtos.ResponseStatus;
import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.GetParkingLotRequestValidationException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.ParkingFloor;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;
import org.example.machineCoding.parkingLot.parkingLotAssignment.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotController {
    private ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public GetParkingLotCapacityResponseDto getParkingLotCapacity(GetParkingLotCapacityRequestDto getParkingLotCapacityRequestDto) {
        try{
            validateRequest(getParkingLotCapacityRequestDto);
            List<VehicleType> vehicleTypes = new ArrayList<>();
            if(getParkingLotCapacityRequestDto.getVehicleTypes() != null) {
                for (String vehicleType : getParkingLotCapacityRequestDto.getVehicleTypes()) {
                    vehicleTypes.add(VehicleType.valueOf(vehicleType));
                }
            }
            Map<ParkingFloor, Map<String, Integer>> parkingLotCapacity = parkingLotService.getParkingLotCapacity(getParkingLotCapacityRequestDto.getParkingLotId(), getParkingLotCapacityRequestDto.getParkingFloorIds(), vehicleTypes);
            GetParkingLotCapacityResponseDto getParkingLotCapacityResponseDto = new GetParkingLotCapacityResponseDto();
            getParkingLotCapacityResponseDto.setCapacityMap(parkingLotCapacity);
            getParkingLotCapacityResponseDto.setResponse(new Response(ResponseStatus.SUCCESS, "Parking Lot Capacity retrieved successfully"));
            return getParkingLotCapacityResponseDto;
        } catch (Exception e){
            GetParkingLotCapacityResponseDto getParkingLotCapacityResponseDto = new GetParkingLotCapacityResponseDto();
            getParkingLotCapacityResponseDto.setResponse(new Response(ResponseStatus.FAILURE, e.getMessage()));
            return getParkingLotCapacityResponseDto;
        }
    }

    private void validateRequest(GetParkingLotCapacityRequestDto getParkingLotCapacityRequestDto) throws GetParkingLotRequestValidationException{
        if(getParkingLotCapacityRequestDto.getParkingLotId() <= 0){
            throw new GetParkingLotRequestValidationException("Invalid Parking Lot Id");
        }
    }


}