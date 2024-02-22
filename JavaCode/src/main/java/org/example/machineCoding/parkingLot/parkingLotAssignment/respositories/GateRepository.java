package org.example.machineCoding.parkingLot.parkingLotAssignment.respositories;



import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Gate;

import java.util.Optional;

public interface GateRepository {
    // Do not modify the method signatures, feel free to add new methods

    public Optional<Gate> findById(long gateId);

    public Gate save(Gate gate);
}
