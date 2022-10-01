package com.roicerbc.votaciones.services;

import com.roicerbc.votaciones.dtos.request.CreateUserRequestDto;
import com.roicerbc.votaciones.dtos.request.UpdateUserRequestDto;
import com.roicerbc.votaciones.dtos.response.CreateUserResponseDto;
import com.roicerbc.votaciones.dtos.response.UserResponseDto;

import java.util.List;

public interface  UserService {
    CreateUserResponseDto create(CreateUserRequestDto user);
    void delete(String id);
    void update(UpdateUserRequestDto user, String id);
    UserResponseDto getById(String id);
    List<UserResponseDto> getUsers(String role);
    List<UserResponseDto> getUsers();
}



