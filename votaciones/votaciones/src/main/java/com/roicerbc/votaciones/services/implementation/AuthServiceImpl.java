package com.roicerbc.votaciones.services.implementation;

import com.roicerbc.votaciones.db.entities.Role;
import com.roicerbc.votaciones.db.entities.User;
import com.roicerbc.votaciones.db.repositories.RoleRepository;
import com.roicerbc.votaciones.db.repositories.UserRepository;
import com.roicerbc.votaciones.dtos.response.RoleResponseDto;
import com.roicerbc.votaciones.dtos.response.UserResponseDto;
import com.roicerbc.votaciones.services.AuthService;
import com.roicerbc.votaciones.exception.Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserResponseDto login(String email, String password) {
        User user = userRepo.findOneByEmail(email).map(x -> x).orElseThrow(() -> new Exception("Usuario no encontrado", 404,new Date()));
        if (!encoder.matches(password, user.getPassword())) throw new Exception("Contraseña invalida", 401, new Date());
        Role role = roleRepo.findById(user.getRoleId()).get();

        return UserResponseDto.builder()
                .role(RoleResponseDto.builder()
                        .name(role.getName())
                        .description(role.getDescription())
                        .build())
                .email(user.getEmail())
                .id(user.get_id())
                .seudonimo(user.getSeudonimo())
                .build();
    }
}