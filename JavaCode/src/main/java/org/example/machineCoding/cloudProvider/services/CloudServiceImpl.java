package org.example.machineCoding.cloudProvider.services;


import org.example.machineCoding.cloudProvider.adapters.CloudAdapter;
import org.example.machineCoding.cloudProvider.exceptions.UserNotFoundException;
import org.example.machineCoding.cloudProvider.models.Connection;
import org.example.machineCoding.cloudProvider.models.User;
import org.example.machineCoding.cloudProvider.repositories.UserRepository;

public class CloudServiceImpl implements CloudService {
    private UserRepository userRepository;
    private CloudAdapter cloudAdapter;
    public CloudServiceImpl(UserRepository userRepository, CloudAdapter cloudAdapter) {
        this.userRepository = userRepository;
        this.cloudAdapter = cloudAdapter;
    }
    @Override
    public Connection createConnection(Long userId) throws UserNotFoundException {
        User user = userRepository.findUserById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        return cloudAdapter.createConnection(userId);
    }
}
