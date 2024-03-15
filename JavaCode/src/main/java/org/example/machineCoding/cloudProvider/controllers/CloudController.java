package org.example.machineCoding.cloudProvider.controllers;


import org.example.machineCoding.cloudProvider.dtos.CreateConnectionRequestDto;
import org.example.machineCoding.cloudProvider.dtos.CreateConnectionResponseDto;
import org.example.machineCoding.cloudProvider.dtos.ResponseStatus;
import org.example.machineCoding.cloudProvider.exceptions.UserNotFoundException;
import org.example.machineCoding.cloudProvider.models.Connection;
import org.example.machineCoding.cloudProvider.services.CloudService;

public class CloudController {
    private CloudService cloudService;

    public CloudController(CloudService cloudService) {
        this.cloudService = cloudService;
    }

    public CreateConnectionResponseDto createConnection(CreateConnectionRequestDto createConnectionRequestDto) {
        CreateConnectionResponseDto responseDto = new CreateConnectionResponseDto();
        try {
            Connection connection = cloudService.createConnection(createConnectionRequestDto.getUserId());
            responseDto.setConnectionId(connection.getConnectionId());
            responseDto.setConnectionStatus(connection.getConnectionStatus());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
