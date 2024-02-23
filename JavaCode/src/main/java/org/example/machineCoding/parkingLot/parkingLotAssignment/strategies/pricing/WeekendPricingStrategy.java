package org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.pricing;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.Slab;
import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;
import org.example.machineCoding.parkingLot.parkingLotAssignment.respositories.SlabRepository;
import org.example.machineCoding.parkingLot.parkingLotAssignment.utils.DateTimeUtils;

import java.util.Date;
import java.util.List;

public class WeekendPricingStrategy implements PricingStrategy{

    private SlabRepository slabRepository;

    public WeekendPricingStrategy(SlabRepository slabRepository) {
        this.slabRepository = slabRepository;
    }

    @Override
    public double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType) {
        List<Slab> slabs = this.slabRepository.getSortedSlabsByVehicleType(vehicleType);
        int hoursSpent = DateTimeUtils.calculateHours(entryTime, exitTime);
        double amount = 0;
        for (Slab slab : slabs) {
            if(hoursSpent > slab.getEndHour() && slab.getEndHour() != -1) { // this means we have consumed entire slab
                amount += (slab.getEndHour() - slab.getStartHour()) * slab.getPrice();
            }
            else if(slab.getEndHour() == -1 || hoursSpent <= slab.getEndHour()){
                amount += (hoursSpent - slab.getStartHour()) * slab.getPrice();
                break;
            }
        }
        return amount;
    }
}

