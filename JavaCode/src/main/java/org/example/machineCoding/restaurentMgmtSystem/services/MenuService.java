package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.restaurentMgmtSystem.exceptions.UnAuthorizedAccess;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.UserNotFoundException;
import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;

import java.util.List;

public interface MenuService {
    MenuItem addMenuItem(long userId, String name, double price, String dietaryRequirement, String itemType, String description) throws UserNotFoundException, UnAuthorizedAccess;

    List<MenuItem> getMenuItems(String dietaryRequirement);
}
