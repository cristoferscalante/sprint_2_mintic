package com.roicerbc.votaciones.services;

import com.roicerbc.votaciones.dtos.response.UserResponseDto;

public interface AuthService {
    UserResponseDto login(String email, String password);
}
