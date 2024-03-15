package org.example.machineCoding.cloudProvider.repositories;



import org.example.machineCoding.cloudProvider.models.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findUserById(long userId);
}
