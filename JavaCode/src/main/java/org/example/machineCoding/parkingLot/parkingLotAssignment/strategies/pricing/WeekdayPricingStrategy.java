package org.example.machineCoding.parkingLot.parkingLotAssignment.strategies.pricing;

import org.example.machineCoding.parkingLot.parkingLotAssignment.models.VehicleType;
import org.example.machineCoding.parkingLot.parkingLotAssignment.utils.*;
import java.util.Date;

public class WeekdayPricingStrategy implements PricingStrategy{

    @Override
    public double calculateAmount(Date entryTime, Date exitTime, VehicleType vehicleType) {
        int hours = DateTimeUtils.calculateHours(entryTime, exitTime);
        return hours * 10;
    }
}