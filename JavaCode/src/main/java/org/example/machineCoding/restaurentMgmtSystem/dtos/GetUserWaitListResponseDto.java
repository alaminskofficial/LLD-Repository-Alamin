package org.example.machineCoding.restaurentMgmtSystem.dtos;

public class GetUserWaitListResponseDto {
    private int position;
    private ResponseStatus responseStatus;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
