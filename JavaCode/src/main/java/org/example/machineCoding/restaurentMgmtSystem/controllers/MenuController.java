package org.example.machineCoding.restaurentMgmtSystem.controllers;


import org.example.machineCoding.restaurentMgmtSystem.dtos.*;
import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;
import org.example.machineCoding.restaurentMgmtSystem.services.MenuService;

import java.util.List;

public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public AddMenuItemResponseDto addMenuItem(AddMenuItemRequestDto requestDto){
        AddMenuItemResponseDto responseDto = new AddMenuItemResponseDto();
        try {
            MenuItem menuItem = menuService.addMenuItem(requestDto.getUserId(), requestDto.getName(), requestDto.getPrice(), requestDto.getDietaryRequirement(), requestDto.getItemType(), requestDto.getDescription());
            responseDto.setMenuItem(menuItem);
            responseDto.setStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto){
        GetMenuItemsResponseDto responseDto = new GetMenuItemsResponseDto();
        try {
            List<MenuItem> menuItems = menuService.getMenuItems(requestDto.getDietaryRequirement());
            responseDto.setMenuItems(menuItems);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return responseDto;
        } catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            return responseDto;
        }
    }
}
