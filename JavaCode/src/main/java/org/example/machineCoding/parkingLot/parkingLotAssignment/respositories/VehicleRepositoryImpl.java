package org.example.machineCoding.parkingLot.parkingLotAssignment.respositories;



import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleRepositoryImpl implements VehicleRepository{

    private final List<Vehicle> vehicles = new ArrayList<>();
    @Override
    public Optional<Vehicle> getVehicleByRegistrationNumber(String registrationNumber) {
        for(Vehicle vehicle:vehicles){
            if(vehicle.getRegistrationNumber()==registrationNumber){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }
}