package org.example.machineCoding.parkingLot.parkingLotAssignment.dtos;

public class GenerateTicketRequestDto {
    private int gateId;
    private String registrationNumber;
    private String vehicleType;

    public int getGateId() {
        return gateId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
}
