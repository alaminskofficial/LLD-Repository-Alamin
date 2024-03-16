package org.example.machineCoding.restaurentMgmtSystem.dtos;

import org.example.machineCoding.restaurentMgmtSystem.models.Order;

public class PlaceOrderResponseDto {
    private ResponseStatus responseStatus;
    private Order order;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
