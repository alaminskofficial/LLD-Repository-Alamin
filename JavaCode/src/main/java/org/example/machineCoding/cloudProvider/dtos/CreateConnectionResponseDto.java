package org.example.machineCoding.cloudProvider.dtos;


import org.example.machineCoding.cloudProvider.models.ConnectionStatus;

public class CreateConnectionResponseDto {
    private String connectionId;
    private ResponseStatus responseStatus;
    private ConnectionStatus connectionStatus;

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public ConnectionStatus getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(ConnectionStatus connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
