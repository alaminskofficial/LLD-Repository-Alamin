package org.example.machineCoding.parkingLot.parkingLotAssignment.dtos;

import java.util.List;

public class GetParkingLotCapacityRequestDto {
    private long parkingLotId;
    private List<Long> parkingFloorIds;

    private List<String> vehicleTypes;

    public long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public List<Long> getParkingFloorIds() {
        return parkingFloorIds;
    }

    public void setParkingFloorIds(List<Long> parkingFloorIds) {
        this.parkingFloorIds = parkingFloorIds;
    }

    public List<String> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<String> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
