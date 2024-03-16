package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.restaurentMgmtSystem.exceptions.UnAuthorizedAccess;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.UserNotFoundException;
import org.example.machineCoding.restaurentMgmtSystem.models.AggregatedRevenue;

public interface RevenueService {
    AggregatedRevenue calculateRevenue(long userId, String revenueQueryType) throws UserNotFoundException, UnAuthorizedAccess;
}
