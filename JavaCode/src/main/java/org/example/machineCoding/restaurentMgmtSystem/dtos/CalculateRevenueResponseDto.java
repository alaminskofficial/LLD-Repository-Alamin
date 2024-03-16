package org.example.machineCoding.restaurentMgmtSystem.dtos;

import org.example.machineCoding.restaurentMgmtSystem.models.AggregatedRevenue;

public class CalculateRevenueResponseDto {
    private AggregatedRevenue aggregatedRevenue;
    private ResponseStatus responseStatus;

    public AggregatedRevenue getAggregatedRevenue() {
        return aggregatedRevenue;
    }

    public void setAggregatedRevenue(AggregatedRevenue aggregatedRevenue) {
        this.aggregatedRevenue = aggregatedRevenue;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
