package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.WaitListPosition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WaitListPositionRepositoryImpl implements WaitListPositionRepository {

    private Map<Long, WaitListPosition> map;

    public WaitListPositionRepositoryImpl() {
        this.map = new HashMap<>();
    }

    private static int idCounter = 0;

    @Override
    public WaitListPosition save(WaitListPosition waitListPosition) {
        if(waitListPosition.getId() == 0){
            waitListPosition.setId(++idCounter);
        }
        map.put(waitListPosition.getId(), waitListPosition);
        return waitListPosition;
    }

    @Override
    public List<WaitListPosition> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public WaitListPosition delete(WaitListPosition waitListPosition) {
        return map.remove(waitListPosition.getId());
    }
}
