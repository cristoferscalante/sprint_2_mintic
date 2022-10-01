package com.roicerbc.votaciones.services.implementation;

import com.roicerbc.votaciones.db.entities.Permission;
import com.roicerbc.votaciones.db.entities.PermissionRole;
import com.roicerbc.votaciones.db.entities.Role;
import com.roicerbc.votaciones.db.repositories.PermissionRepository;
import com.roicerbc.votaciones.db.repositories.PermissionRoleRepository;
import com.roicerbc.votaciones.db.repositories.RoleRepository;
import com.roicerbc.votaciones.dtos.response.PermissionResponseDto;
import com.roicerbc.votaciones.dtos.response.RoleResponseDto;
import com.roicerbc.votaciones.exception.Exception;
import com.roicerbc.votaciones.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository repo;
    @Autowired
    private PermissionRoleRepository permissionRoleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<RoleResponseDto> getAllRoles() {
        List<Role> roles= this.repo.findAll();
        return roles.stream().map(x -> RoleResponseDto.builder()
                .name(x.getName())
                .description(x.getDescription())
                .build()
        ).collect(Collectors.toList());

    }

    @Override
    public List<PermissionResponseDto> getAllPermission(String role) {
        Role r= repo.findOneByName(role).map(x->x).orElseThrow(()-> new Exception("rol Invalido",400, new Date()));
        String id= r.get_id();
        List<PermissionRole> permissionRoles = permissionRoleRepository.findAllByRoleId(id);
        List<PermissionResponseDto> permissions = new ArrayList<>();
        if (!permissionRoles.isEmpty()) {
            List<String> ids = permissionRoles.stream().map(x-> x.getPermissionId()).collect(Collectors.toList());
            List<Permission> p = permissionRepository.findAllByIds(ids);
            permissions = p.stream().map(x -> PermissionResponseDto.builder()
                    .method(x.getMethod().toString())
                    .url(x.getUrl())
                    .build()).collect(Collectors.toList());
        }
        return permissions;
    }
}