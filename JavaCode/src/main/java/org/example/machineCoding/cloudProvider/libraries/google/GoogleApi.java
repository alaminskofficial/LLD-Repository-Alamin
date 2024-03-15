package org.example.machineCoding.cloudProvider.libraries.google;

import java.util.Date;
import java.util.UUID;

public class GoogleApi {
    public GoogleConnectionResponse createConnection(long userId) {
        GoogleConnectionResponse googleConnectionResponse = new GoogleConnectionResponse();
        googleConnectionResponse.setConnectionId(UUID.randomUUID().toString());
        googleConnectionResponse.setConnectionStatus("SUCCESS");
        googleConnectionResponse.setConnectionDate(new Date());
        return googleConnectionResponse;
    }
}
