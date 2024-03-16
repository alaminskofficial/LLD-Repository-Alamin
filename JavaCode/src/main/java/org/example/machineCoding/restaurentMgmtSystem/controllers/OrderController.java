package org.example.machineCoding.restaurentMgmtSystem.controllers;

import org.example.machineCoding.restaurentMgmtSystem.dtos.*;
import org.example.machineCoding.restaurentMgmtSystem.models.Bill;
import org.example.machineCoding.restaurentMgmtSystem.models.Order;
import org.example.machineCoding.restaurentMgmtSystem.services.OrderService;

public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    public PlaceOrderResponseDto placeOrder(PlaceOrderRequestDto requestDto){
        PlaceOrderResponseDto responseDto = new PlaceOrderResponseDto();
        try {
            Order order = orderService.placeOrder(requestDto.getUserId(), requestDto.getOrderedItems());
            responseDto.setOrder(order);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
    public GenerateBillResponseDto generateBill(GenerateBillRequestDto requestDto){
        GenerateBillResponseDto responseDto = new GenerateBillResponseDto();
        try {
            Bill bill = orderService.generateBill(requestDto.getUserId());
            responseDto.setBill(bill);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }

}
