package org.example.machineCoding.restaurentMgmtSystem.models;

import java.util.Date;

public class AggregatedRevenue {
    private double revenueFromFoodSales;
    private Date fromDate;

    private Date toDate;
    private double totalGst;
    private double totalServiceCharge;
    private double totalRevenue;

    public double getRevenueFromFoodSales() {
        return revenueFromFoodSales;
    }

    public void setRevenueFromFoodSales(double revenueFromFoodSales) {
        this.revenueFromFoodSales = revenueFromFoodSales;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getTotalGst() {
        return totalGst;
    }

    public void setTotalGst(double totalGst) {
        this.totalGst = totalGst;
    }

    public double getTotalServiceCharge() {
        return totalServiceCharge;
    }

    public void setTotalServiceCharge(double totalServiceCharge) {
        this.totalServiceCharge = totalServiceCharge;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
