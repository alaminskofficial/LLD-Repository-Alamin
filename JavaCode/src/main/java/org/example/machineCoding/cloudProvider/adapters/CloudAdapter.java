package org.example.machineCoding.cloudProvider.adapters;


import org.example.machineCoding.cloudProvider.models.Connection;

public interface CloudAdapter {
    Connection createConnection(long userId);
}
