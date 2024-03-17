package org.example.machineCoding.restaurentMgmtSystem.controllers;

import org.example.machineCoding.restaurentMgmtSystem.dtos.*;
import org.example.machineCoding.restaurentMgmtSystem.services.WaitListService;

public class WaitListController {

    public WaitListService waitListService;

    public WaitListController(WaitListService waitListService) {
        this.waitListService = waitListService;
    }

    public AddUserToWaitListResponseDto addUserToWaitList(AddUserToWaitListRequestDto requestDto) {
        AddUserToWaitListResponseDto responseDto = new AddUserToWaitListResponseDto();
        try {
            int position = waitListService.addUserToWaitList(requestDto.getUserId());
            responseDto.setPosition(position);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public UpdateWaitListResponseDto updateWaitList(UpdateWaitListRequestDto requestDto) {
        UpdateWaitListResponseDto responseDto = new UpdateWaitListResponseDto();
        try {
            waitListService.updateWaitList(requestDto.getUserId(), requestDto.getNumberOfSeats());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public GetUserWaitListResponseDto getWaitListStatus(GetUserWaitListRequestDto requestDto){
        GetUserWaitListResponseDto responseDto = new GetUserWaitListResponseDto();
        try {
            int position = waitListService.getWaitListPosition(requestDto.getUserId());
            responseDto.setPosition(position);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
