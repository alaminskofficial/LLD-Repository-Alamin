package org.example.machineCoding.splitwise.basicFlow.repositories;



import org.example.machineCoding.splitwise.basicFlow.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> userList;

    public UserRepository() {
        userList = new ArrayList<>();
    }

    public void addUser(User user){
        userList.add(user);
    }
}
