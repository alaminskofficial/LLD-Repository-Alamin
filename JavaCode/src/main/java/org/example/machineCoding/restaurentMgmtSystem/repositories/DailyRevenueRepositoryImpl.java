package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.DailyRevenue;
import org.example.machineCoding.restaurentMgmtSystem.utils.DateUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DailyRevenueRepositoryImpl implements DailyRevenueRepository{
    private Map<Long, DailyRevenue> dailyRevenueMap;
    private static long idCounter = 0;

    public DailyRevenueRepositoryImpl() {
        this.dailyRevenueMap = new HashMap<>();
    }

    @Override
    public DailyRevenue save(DailyRevenue dailyRevenue) {
        if(dailyRevenue.getId() == 0){
            dailyRevenue.setId(++idCounter);
        }
        dailyRevenueMap.put(dailyRevenue.getId(), dailyRevenue);
        return dailyRevenue;
    }

    @Override
    public List<DailyRevenue> getDailyRevenueBetweenDates(Date startDate, Date endDate) {
        return dailyRevenueMap.values().stream().filter(dailyRevenue -> {
            Date date = dailyRevenue.getDate();
            return (date.compareTo(startDate) >= 0 || DateUtils.equalDates(date, startDate)) && (date.compareTo(endDate) <= 0 || DateUtils.equalDates(date, endDate));
        }).toList();
    }

}
