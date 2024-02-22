package org.example.machineCoding.parkingLot.parkingLotAssignment.services;

import org.example.machineCoding.parkingLot.parkingLotAssignment.exceptions.InvalidParkingLotException;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.ParkingFloor;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.ParkingLot;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.ParkingLotRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.utils.ParkingFloorUtils;

import java.util.*;

public class ParkingLotServiceImpl implements ParkingLotService{

    private ParkingLotRepository parkingLotRepository;

    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public Map<ParkingFloor, Map<String, Integer>> getParkingLotCapacity(long parkingLotId, List<Long> parkingFloorIds, List<VehicleType> inputVehicleTypes) throws InvalidParkingLotException {
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getParkingLotById(parkingLotId);
        if(parkingLotOptional.isEmpty()){
            throw new InvalidParkingLotException("Invalid Parking Lot Id , Please try again...");
        }

        ParkingLot parkingLot = parkingLotOptional.get();
        Map<ParkingFloor, Map<String, Integer>> map = new HashMap<>();
        Set<Long> parkingFloorIdSet = (parkingFloorIds == null) ? new HashSet<>(): new HashSet<>(parkingFloorIds);

        if(inputVehicleTypes == null || inputVehicleTypes.isEmpty()){
            inputVehicleTypes = Arrays.asList(VehicleType.values());
        }

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloors()){
            if(parkingFloorIdSet.size() > 0 && !parkingFloorIdSet.contains(parkingFloor.getId())){
                continue;
            }
            Map<String, Integer> vehicleTypeMap = new HashMap<>();
            for(VehicleType vehicleType : inputVehicleTypes){
                vehicleTypeMap.put(vehicleType.name(), ParkingFloorUtils.calculateAvailableSpotsByVehicleType(parkingFloor, vehicleType));
            }
            map.put(parkingFloor, vehicleTypeMap);
        }
        return map;
    }
}
