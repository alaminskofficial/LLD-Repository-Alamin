package org.example.machineCoding.parkingLot.parkingLotAssignment.respositories;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Slab;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;

import java.util.*;

public class SlabRepositoryImpl implements SlabRepository {
    private static int ID = 0;
    private Map<Long, Slab> map;

    public SlabRepositoryImpl() {
        this.map = new HashMap<>();
    }
    @Override
    public List<Slab> getSortedSlabsByVehicleType(VehicleType vehicleType){
        List<Slab> result = new ArrayList<>();
        for (Map.Entry<Long, Slab> entry : map.entrySet()) {
            if(entry.getValue().getVehicleType().equals(vehicleType)){
                result.add(entry.getValue());
            }
        }
        //ascending order by startHour
        result.sort(new Comparator<Slab>() {
            @Override
            public int compare(Slab o1, Slab o2) {
                return o1.getStartHour()-o2.getStartHour();
            }
        });
        return result;
    }

    @Override
    public Slab save(Slab slab) {
        if (slab.getId() == 0) {
            slab.setId(map.size() + 1);
        }
        map.put(slab.getId(), slab);
        return slab;
    }
}

