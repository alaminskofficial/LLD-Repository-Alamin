package org.example.machineCoding.cloudProvider.repositories;



import org.example.machineCoding.cloudProvider.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private Map<Long, User> userMap;

    public UserRepositoryImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(userMap.size() + 1);
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findUserById(long userId) {
        return Optional.ofNullable(userMap.get(userId));
    }
}
