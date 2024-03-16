package org.example.machineCoding.restaurentMgmtSystem.services;

import org.example.machineCoding.restaurentMgmtSystem.exceptions.UnAuthorizedAccess;
import org.example.machineCoding.restaurentMgmtSystem.exceptions.UserNotFoundException;

import org.example.machineCoding.restaurentMgmtSystem.models.*;
import org.example.machineCoding.restaurentMgmtSystem.repositories.MenuRepository;
import org.example.machineCoding.restaurentMgmtSystem.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    public MenuServiceImpl(MenuRepository menuRepository, UserRepository userRepository) {
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
    }

    @Override
    public MenuItem addMenuItem(long userId, String name, double price, String dietaryRequirement, String itemType, String description) throws UserNotFoundException, UnAuthorizedAccess {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User not found Exception");
        }
        User user = userOptional.get();
        if(user.getUserType() != UserType.ADMIN){
            throw new UnAuthorizedAccess("User is not an admin , try with different admin user");
        }
        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setPrice(price);
        menuItem.setDietaryRequirement(DietaryRequirement.valueOf(dietaryRequirement));
        menuItem.setItemType(ItemType.valueOf(itemType));
        menuItem.setDescription(description);
        menuItem = menuRepository.add(menuItem);
        return menuItem;
    }
    @Override
    public List<MenuItem> getMenuItems(String itemType) {
        if(itemType == null){
            return menuRepository.getAll();
        } else{
            return menuRepository.getByDietaryRequirement(DietaryRequirement.valueOf(itemType));
        }
    }

}
