package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.restaurentMgmtSystem.exceptions.UnAuthorizedAccess;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.UserNotFoundException;
import org.example.machineCoding.restaurentMgmtSystem.models.*;
import org.example.machineCoding.restaurentMgmtSystem.repositories.DailyRevenueRepository;
import org.example.machineCoding.restaurentMgmtSystem.repositories.UserRepository;
import org.example.machineCoding.restaurentMgmtSystem.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class RevenueServiceImpl implements RevenueService{

    private DailyRevenueRepository dailyRevenueRepository;

    private UserRepository userRepository;

    public RevenueServiceImpl(DailyRevenueRepository dailyRevenueRepository, UserRepository userRepository) {
        this.dailyRevenueRepository = dailyRevenueRepository;
        this.userRepository = userRepository;
    }


    @Override
    public AggregatedRevenue calculateRevenue(long userId, String queryType) throws UserNotFoundException, UnAuthorizedAccess {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User not found...");
        }
        User user = optionalUser.get();
        if(user.getUserType() != UserType.BILLING){
            throw new UnAuthorizedAccess("User is not a billing user , try with different user...");
        }
        RevenueQueryType revenueQueryType = RevenueQueryType.valueOf(queryType);
        Pair<Date, Date> dates = DateUtils.getStartAndEndDateByQueryType(revenueQueryType);
        Date startDate = dates.getLeft();
        Date endDate = dates.getRight();
        List<DailyRevenue> dailyRevenueBetweenDates = dailyRevenueRepository.getDailyRevenueBetweenDates(startDate, endDate);
        double totalRevenueFromFoodSales = dailyRevenueBetweenDates.stream().mapToDouble(DailyRevenue::getRevenueFromFoodSales).sum();
        double totalGst = dailyRevenueBetweenDates.stream().mapToDouble(DailyRevenue::getTotalGst).sum();
        double totalServiceCharge = dailyRevenueBetweenDates.stream().mapToDouble(DailyRevenue::getTotalServiceCharge).sum();
        AggregatedRevenue aggregatedRevenue = new AggregatedRevenue();
        aggregatedRevenue.setTotalRevenue(totalRevenueFromFoodSales + totalGst + totalServiceCharge);
        aggregatedRevenue.setTotalGst(totalGst);
        aggregatedRevenue.setTotalServiceCharge(totalServiceCharge);
        aggregatedRevenue.setFromDate(startDate);
        aggregatedRevenue.setToDate(endDate);
        aggregatedRevenue.setRevenueFromFoodSales(totalRevenueFromFoodSales);
        return aggregatedRevenue;
    }
}
