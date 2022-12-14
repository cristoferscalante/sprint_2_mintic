package com.roicerbc.votaciones.controller;

import com.roicerbc.votaciones.dtos.request.CreateUserRequestDto;
import com.roicerbc.votaciones.dtos.request.UpdateUserRequestDto;
import com.roicerbc.votaciones.dtos.response.CreateUserResponseDto;
import com.roicerbc.votaciones.dtos.response.UserResponseDto;
import com.roicerbc.votaciones.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController //para que sea considerado un controlador
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/roles/{role:Admin|Jurado|Ciudadano}")
    public ResponseEntity<List<UserResponseDto>> getAllByRole(@PathVariable String role) {
        return ResponseEntity.ok(service.getUsers(role));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CreateUserResponseDto> create(@RequestBody @Valid CreateUserRequestDto request) {
        return ResponseEntity.ok(service.create(request));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateUserRequestDto request, @PathVariable String id) {
        service.update(request,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}

