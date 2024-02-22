package org.example.machineCoding.parkingLot.parkingLotBasicFlow.repositories;





import org.example.machineCoding.parkingLot.parkingLotBasicFlow.exceptions.GateNotFoundException;
import org.example.machineCoding.parkingLot.parkingLotBasicFlow.models.Gate;

import java.util.HashMap;
import java.util.Map;


public class GateRepository {

    // It should be able to do crud operations on gate.

    private Map<Long, Gate> gates = new HashMap<>();

    public Map<Long, Gate> getGates() {
        return gates;
    }

    public void setGates(Map<Long, Gate> gates) {
        this.gates = gates;
    }

    public Gate findGateById(Long id) throws GateNotFoundException {
        if(gates.containsKey(id)){
            return gates.get(id);
        }
        throw new GateNotFoundException("Gate not found exception");
    }
}
