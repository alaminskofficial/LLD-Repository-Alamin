package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.restaurentMgmtSystem.exceptions.UnAuthorizedAccess;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.UserNotFoundException;
import org.example.machineCoding.restaurentMgmtSystem.models.User;
import org.example.machineCoding.restaurentMgmtSystem.models.UserType;
import org.example.machineCoding.restaurentMgmtSystem.models.WaitListPosition;
import org.example.machineCoding.restaurentMgmtSystem.repositories.UserRepository;
import org.example.machineCoding.restaurentMgmtSystem.repositories.WaitListPositionRepository;

import java.util.Date;
import java.util.List;

public interface WaitListService {

    int addUserToWaitList(long userId) throws UserNotFoundException;

    int getWaitListPosition(long userId) throws UserNotFoundException;

    void updateWaitList(long adminUserId, int numberOfSpots) throws UserNotFoundException,UnAuthorizedAccess;

}
