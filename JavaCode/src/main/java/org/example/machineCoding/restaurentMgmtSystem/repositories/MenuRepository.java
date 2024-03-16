package org.example.machineCoding.restaurentMgmtSystem.repositories;

import org.example.machineCoding.restaurentMgmtSystem.models.DietaryRequirement;
import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;

import java.util.List;

public interface MenuRepository {

    MenuItem add(MenuItem menuItem);
    List<MenuItem> getAll();

    List<MenuItem> getByDietaryRequirement(DietaryRequirement dietaryRequirement);
}
