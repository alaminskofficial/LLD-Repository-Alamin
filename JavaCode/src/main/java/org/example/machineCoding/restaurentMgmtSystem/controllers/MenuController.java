package org.example.machineCoding.restaurentMgmtSystem.controllers;


import org.example.machineCoding.restaurentMgmtSystem.dtos.AddMenuItemRequestDto;
import org.example.machineCoding.restaurentMgmtSystem.dtos.AddMenuItemResponseDto;
import org.example.machineCoding.restaurentMgmtSystem.dtos.ResponseStatus;
import org.example.machineCoding.restaurentMgmtSystem.models.MenuItem;
import org.example.machineCoding.restaurentMgmtSystem.services.MenuService;

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
}
