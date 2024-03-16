package org.example.machineCoding.restaurentMgmtSystem.models;

import java.util.Map;

public class Bill extends BaseModel {
    private String id;
    private Map<MenuItem, Integer> orderedItems;
    private double totalAmount;
    private double gst;
    private double serviceCharge;

}
