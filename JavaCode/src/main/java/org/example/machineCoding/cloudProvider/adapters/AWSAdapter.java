package org.example.machineCoding.cloudProvider.adapters;


import org.example.machineCoding.cloudProvider.libraries.aws.AWSApi;
import org.example.machineCoding.cloudProvider.libraries.aws.AWSConnectionResponse;
import org.example.machineCoding.cloudProvider.models.Connection;
import org.example.machineCoding.cloudProvider.models.ConnectionStatus;

public class AWSAdapter implements CloudAdapter {
    private AWSApi awsApi;
    public AWSAdapter() {
        this.awsApi = new AWSApi();
    }

    @Override
    public Connection createConnection(long userId) {
        AWSConnectionResponse awsConnectionResponse = awsApi.createConnection(userId);
        Connection connection = new Connection();
        connection.setConnectionId(awsConnectionResponse.getConnectionId());
        connection.setConnectionStatus(ConnectionStatus.valueOf(awsConnectionResponse.getConnectionStatus()));
        connection.setUserId(userId);
        return connection;
    }
}
