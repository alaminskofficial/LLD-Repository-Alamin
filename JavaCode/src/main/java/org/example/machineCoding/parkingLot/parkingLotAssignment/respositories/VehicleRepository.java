package org.example.machineCoding.parkingLotAssignment.respositories;

import org.example.machineCoding.parkingLotAssignment.models.Vehicle;

import java.util.Optional;

public interface VehicleRepository {
    // Do not modify the method signatures, feel free to add new methods

    public Optional<Vehicle> getVehicleByRegistrationNumber(String registrationNumber);

    public Vehicle save(Vehicle vehicle);
}
