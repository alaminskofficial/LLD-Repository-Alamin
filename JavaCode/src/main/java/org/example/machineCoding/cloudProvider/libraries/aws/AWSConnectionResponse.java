package org.example.machineCoding.cloudProvider.libraries.aws;

import java.util.Date;

public class AWSConnectionResponse {
    private String connectionId;
    private String connectionStatus;
    private Date connectionDate;

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public Date getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(Date connectionDate) {
        this.connectionDate = connectionDate;
    }
}
