package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.Bill;

import java.util.Optional;

public interface BillRepository {
    Bill save(Bill bill);
    Optional<Bill> findById(long billId);
}
