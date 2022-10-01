package com.roicerbc.votaciones.controller;

import com.roicerbc.votaciones.dtos.request.LoginDto;
import com.roicerbc.votaciones.dtos.response.UserResponseDto;
import com.roicerbc.votaciones.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/")
    public ResponseEntity<UserResponseDto> login(@RequestBody @Valid LoginDto request) {
        var result = this.service.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(result);
    }
}

