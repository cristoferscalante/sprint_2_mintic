package com.roicerbc.votaciones.services;

import com.roicerbc.votaciones.dtos.response.PermissionResponseDto;
import com.roicerbc.votaciones.dtos.response.RoleResponseDto;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> getAllRoles();
    List<PermissionResponseDto> getAllPermission(String role);
}