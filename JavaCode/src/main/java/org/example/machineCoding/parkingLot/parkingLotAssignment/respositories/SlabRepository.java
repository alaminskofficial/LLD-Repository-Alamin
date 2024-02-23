package org.example.machineCoding.parkingLot.parkingLotAssignment.respositories;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Slab;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;

import java.util.List;

public interface SlabRepository {
    public List<Slab> getSortedSlabsByVehicleType(VehicleType vehicleType);

    public Slab save(Slab slab);
}
