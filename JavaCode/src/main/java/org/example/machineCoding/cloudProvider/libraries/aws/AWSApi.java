package org.example.machineCoding.cloudProvider.libraries.aws;

import java.util.Date;
import java.util.UUID;

public class AWSApi {
    public AWSConnectionResponse createConnection(long userId) {
        AWSConnectionResponse awsConnectionResponse = new AWSConnectionResponse();
        awsConnectionResponse.setConnectionId(UUID.randomUUID().toString());
        awsConnectionResponse.setConnectionStatus("SUCCESS");
        awsConnectionResponse.setConnectionDate(new Date());
        return awsConnectionResponse;
    }
}
