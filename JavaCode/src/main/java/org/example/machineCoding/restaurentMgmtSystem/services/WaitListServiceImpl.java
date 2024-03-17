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

public class WaitListServiceImpl implements WaitListService{

    private WaitListPositionRepository waitListPositionRepository;
    private UserRepository userRepository;

    public WaitListServiceImpl(WaitListPositionRepository waitListPositionRepository, UserRepository userRepository) {
        this.waitListPositionRepository = waitListPositionRepository;
        this.userRepository = userRepository;
    }


    @Override
    public int addUserToWaitList(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        List<WaitListPosition> all = waitListPositionRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getUser().getId() == user.getId()) {
                return i + 1;
            }
        }
        WaitListPosition waitListPosition = new WaitListPosition();
        waitListPosition.setUser(user);
        waitListPosition.setInsertedAt(new Date());
        waitListPositionRepository.save(waitListPosition);
        all = waitListPositionRepository.findAll();
        return all.size();
    }

    @Override
    public int getWaitListPosition(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        List<WaitListPosition> all = waitListPositionRepository.findAll();
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getUser().getId() == user.getId()) {
                return i + 1;
            }
        }
        return -1;
    }

    @Override
    public void updateWaitList(long adminUserId, int numberOfSpots) throws UserNotFoundException, UnAuthorizedAccess {
        User adminUser = userRepository.findById(adminUserId).orElseThrow(() -> new UserNotFoundException("User not found"));
        if(adminUser.getUserType() != UserType.ADMIN) {
            //throw new UnAuthorizedAccess("User not found....");
            throw  new UnAuthorizedAccess("User Not Found ..");
        }
        List<WaitListPosition> all = waitListPositionRepository.findAll();
        numberOfSpots = Math.min(numberOfSpots, all.size());
        for (int i = 0; i < numberOfSpots; i++) {
            waitListPositionRepository.delete(all.get(i));
        }
    }
}
