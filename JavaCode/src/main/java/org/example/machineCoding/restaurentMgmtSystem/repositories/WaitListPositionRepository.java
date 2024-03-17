package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.WaitListPosition;

import java.util.List;

public interface WaitListPositionRepository {
    WaitListPosition save(WaitListPosition waitListPosition);

    List<WaitListPosition> findAll();

    WaitListPosition delete(WaitListPosition waitListPosition);
}
