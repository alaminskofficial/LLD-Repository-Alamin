package org.example.machineCoding.restaurentMgmtSystem.models;

import java.util.Map;

public class Order extends BaseModel{
    private CustomerSession customerSession;
    private Map<MenuItem, Integer> orderedItems;

    public CustomerSession getCustomerSession() {
        return customerSession;
    }

    public void setCustomerSession(CustomerSession customerSession) {
        this.customerSession = customerSession;
    }

    public Map<MenuItem, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Map<MenuItem, Integer> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
