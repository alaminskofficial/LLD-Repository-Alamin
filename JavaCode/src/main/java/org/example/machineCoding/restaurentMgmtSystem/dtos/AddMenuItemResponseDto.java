package org.example.machineCoding.restaurentMgmtSystem.dtos;

import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;

public class AddMenuItemResponseDto {
    private ResponseStatus status;
    private MenuItem menuItem;


    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }
}
