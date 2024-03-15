package org.example.machineCoding.cloudProvider.adapters;


import org.example.machineCoding.cloudProvider.libraries.google.GoogleApi;
import org.example.machineCoding.cloudProvider.libraries.google.GoogleConnectionResponse;
import org.example.machineCoding.cloudProvider.models.Connection;
import org.example.machineCoding.cloudProvider.models.ConnectionStatus;

public class GoogleAdapter implements CloudAdapter {
    private GoogleApi googleApi;

    public GoogleAdapter() {
        this.googleApi = new GoogleApi();
    }

    @Override
    public Connection createConnection(long userId) {
        GoogleConnectionResponse googleConnectionResponse = googleApi.createConnection(userId);
        Connection connection = new Connection();
        connection.setUserId(userId);
        connection.setConnectionStatus(ConnectionStatus.valueOf(googleConnectionResponse.getConnectionStatus()));
        connection.setConnectionId(googleConnectionResponse.getConnectionId());
        return connection;
    }
}
