package org.example.machineCoding.parkingLot.parkingLotBasicFlow.strategies;


import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.ParkingLotFullException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.*;

public class SimpleParkingSpotAllotmentStrategy implements ParkingPlaceAllotmentStrategy{


    @Override
    public ParkingSpot getParkingSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingLotFullException {

        /*
          1. Get all the floors of the parking lot
             For each floor, check the slots with vehicletype and status being AVAILABLE
             return it.
         */

        for(Floor floor: parkingLot.getFloors()){
            for(ParkingSpot parkingSpot: floor.getParkingSpots()){
                if(parkingSpot.getStatus().equals(ParkingSpotStatus.AVAILABLE)){
                    if(parkingSpot.getVehicleType().equals(vehicleType)){
                        parkingSpot.setStatus(ParkingSpotStatus.FILLED);
                        return parkingSpot;
                    }
                }
            }
        }
        throw new ParkingLotFullException("parking lot is full...");
    }
}
