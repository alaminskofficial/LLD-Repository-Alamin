package org.example.machineCoding.restaurentMgmtSystem.dtos;
import org.example.machineCoding.restaurentMgmtSystem.models.Bill;
public class GenerateBillResponseDto {
    private ResponseStatus responseStatus;
    private Bill bill;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
