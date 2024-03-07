package org.example.machineCoding.splitwise.basicFlow.controllers;



import org.example.machineCoding.splitwise.basicFlow.dtos.Transaction;
import org.example.machineCoding.splitwise.basicFlow.services.UserService;

import java.util.List;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<Transaction> settleUser(String userName, String groupName){
        return userService.settleUser(userName, groupName);
    }
}
