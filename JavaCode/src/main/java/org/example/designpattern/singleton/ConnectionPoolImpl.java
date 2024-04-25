package org.example.designpattern.singleton;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPoolImpl implements  ConnectionPool{
    private static ConnectionPoolImpl connectionPool = null;
    private  final int maxConnections;
    private Queue<DatabaseConnection> dbConnections;

    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        dbConnections = new LinkedList<>();
        initializePool();
    }
    public static ConnectionPoolImpl getInstance(int maxConnections){
        if(connectionPool == null){
            synchronized (ConnectionPoolImpl.class){
                if(connectionPool == null){
                    connectionPool = new ConnectionPoolImpl(maxConnections);
                }
            }
        }
        return connectionPool;
    }
    public static void resetInstance() {
        connectionPool = null;
    }

    @Override
    public void initializePool() {
        for(int i = 0 ; i < maxConnections ; i++){
            dbConnections.add(new DatabaseConnection());
        }
    }

    @Override
    public DatabaseConnection getConnection() {
        return dbConnections.poll();
    }

    @Override
    public void releaseConnection(DatabaseConnection connection) {
        dbConnections.add(connection);
    }

    @Override
    public int getAvailableConnectionsCount() {
        return dbConnections.size();
    }

    @Override
    public int getTotalConnectionsCount() {
        return this.maxConnections;
    }
}
