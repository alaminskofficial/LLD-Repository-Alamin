package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.Bill;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BillRepositoryImpl implements BillRepository{
    private Map<Long, Bill> billMap;

    public BillRepositoryImpl() {
        this.billMap = new HashMap<>();
    }

    @Override
    public Bill save(Bill bill) {
        if(bill.getId() == 0){
            bill.setId(billMap.size() + 1);
        }
        billMap.put(bill.getId(), bill);
        return bill;
    }

    @Override
    public Optional<Bill> findById(long billId) {
        return Optional.ofNullable(billMap.get(billId));
    }
}
