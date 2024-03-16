package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.restaurentMgmtSystem.exceptions.CustomerSessionNotFound;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.InvalidMenuItem;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.UserNotFoundException;
import org.example.machineCoding.restaurentMgmtSystem.models.Bill;
import org.example.machineCoding.restaurentMgmtSystem.models.Order;

import java.util.Map;

public interface OrderService {

    public Order placeOrder(long userId, Map<Long,Integer> orderedItems) throws UserNotFoundException, InvalidMenuItem;

    Bill generateBill(long userId) throws CustomerSessionNotFound;
}
