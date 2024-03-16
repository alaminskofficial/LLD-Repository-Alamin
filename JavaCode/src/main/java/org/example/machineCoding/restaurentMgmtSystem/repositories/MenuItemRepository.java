package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;

import java.util.Optional;

public interface MenuItemRepository {
    MenuItem add(MenuItem menuItem);

    Optional<MenuItem> findById(long id);
}
