package org.example.machineCoding.restaurentMgmtSystem.dtos;
import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;

import java.util.List;

public class GetMenuItemsResponseDto {
    private List<MenuItem> menuItems;
    private ResponseStatus responseStatus;

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
