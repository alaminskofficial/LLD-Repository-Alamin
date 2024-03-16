package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MenuItemRepositoryImpl implements MenuItemRepository{

    private Map<Long, MenuItem> menuItems;
    private static long idCounter = 0;

    public MenuItemRepositoryImpl() {
        menuItems = new HashMap<>();
    }

    @Override
    public MenuItem add(MenuItem menuItem) {
        if(menuItem.getId() == 0){
            menuItem.setId(++idCounter);
        }
        menuItems.put(menuItem.getId(), menuItem);
        return menuItem;
    }

    @Override
    public Optional<MenuItem> findById(long id) {
        return menuItems.values().stream().filter(menuItem -> menuItem.getId() == id).findFirst();
    }
}
