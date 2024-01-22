package org.example.designpattern.singleton.connectionPool;

public class ClientForConnectionPool {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance(5);
        // Get a connection
        DatabaseConnection connection1 = connectionPool.getConnection();
        System.out.println("Available Connections first step: " + connectionPool.getAvailableConnectionsCount());

        // Release the connection
        connectionPool.releaseConnection(connection1);
        System.out.println("Available Connections next step: " + connectionPool.getAvailableConnectionsCount());

    }
}
