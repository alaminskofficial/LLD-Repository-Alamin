package org.example.machineCoding.parkingLotAssignment.respositories;

import org.example.machineCoding.parkingLotAssignment.models.Gate;

import java.util.*;

public class GateRepositoryImpl implements GateRepository{

    private final Map<Long, Gate> gates = new HashMap<>();
    @Override
    public Optional<Gate> findById(long gateId) {
        return Optional.ofNullable(gates.get(gateId));
    }

    @Override
    public Gate save(Gate gate) {
        gates.put(gate.getId(), gate);
        return gate;
    }
}