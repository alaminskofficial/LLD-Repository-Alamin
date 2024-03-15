package org.example.machineCoding.cloudProvider.services;


import org.example.machineCoding.cloudProvider.exceptions.UserNotFoundException;
import org.example.machineCoding.cloudProvider.models.Connection;

public interface CloudService {
    Connection createConnection(Long userId) throws UserNotFoundException;
}
