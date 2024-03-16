package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository{
    private Map<Long, Order> ordersMap;
    private static long idCounter = 0;

    public OrderRepositoryImpl() {
        ordersMap = new HashMap<>();
    }

    @Override
    public Order save(Order order) {
        if(order.getId() == 0){
            order.setId(++idCounter);
        }
        ordersMap.put(order.getId(), order);
        return order;
    }
}
