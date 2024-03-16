package org.example.machineCoding.restaurentMgmtSystem.controllers;

import org.example.machineCoding.restaurentMgmtSystem.dtos.CalculateRevenueRequestDto;
import org.example.machineCoding.restaurentMgmtSystem.dtos.CalculateRevenueResponseDto;
import org.example.machineCoding.restaurentMgmtSystem.dtos.ResponseStatus;
import org.example.machineCoding.restaurentMgmtSystem.models.AggregatedRevenue;
import org.example.machineCoding.restaurentMgmtSystem.services.RevenueService;

public class RevenueController {

    private RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    public CalculateRevenueResponseDto calculateRevenue(CalculateRevenueRequestDto requestDto){
        CalculateRevenueResponseDto responseDto = new CalculateRevenueResponseDto();
        try {
            AggregatedRevenue aggregatedRevenue = revenueService.calculateRevenue(requestDto.getUserId(), requestDto.getRevenueQueryType());
            responseDto.setAggregatedRevenue(aggregatedRevenue);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
}
