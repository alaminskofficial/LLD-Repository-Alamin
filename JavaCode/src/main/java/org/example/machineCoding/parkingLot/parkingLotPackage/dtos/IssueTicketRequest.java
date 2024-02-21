package org.example.machineCoding.parkingLot.dtos;


import org.example.machineCoding.parkingLot.models.VehicleType;
import org.example.machineCoding.parkingLot.strategies.ParkingPlaceAllotmentStrategy;

public class IssueTicketRequest {

    private VehicleType vehicleType;
    private String vehicleNumber;
    private String owner;
    private Long gateId;
    private Long parkingLotId;
    private ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy;

    public IssueTicketRequest(String vehicleNumber, Long gateId, Long parkingLotId, ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.vehicleNumber = vehicleNumber;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public IssueTicketRequest(VehicleType vehicleType, String vehicleNumber, String owner, Long gateId, Long parkingLotId, ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.owner = owner;
        this.gateId = gateId;
        this.parkingLotId = parkingLotId;
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public ParkingPlaceAllotmentStrategy getParkingPlaceAllotmentStrategy() {
        return parkingPlaceAllotmentStrategy;
    }

    public void setParkingPlaceAllotmentStrategy(ParkingPlaceAllotmentStrategy parkingPlaceAllotmentStrategy) {
        this.parkingPlaceAllotmentStrategy = parkingPlaceAllotmentStrategy;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }
}
