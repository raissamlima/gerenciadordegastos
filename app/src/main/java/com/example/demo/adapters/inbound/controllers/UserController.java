package com.example.demo.adapters.inbound.controllers;

import com.example.demo.adapters.inbound.dto.UserRequestDTO;
import com.example.demo.adapters.inbound.dto.UserResponseDTO;
import com.example.demo.application.usecase.CreateUserUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final CreateUserUseCase createUseCase;

    public UserController(CreateUserUseCase createUseCase){
        this.createUseCase = createUseCase;
    }

    @PostMapping
    public UserResponseDTO create(@RequestBody UserRequestDTO request){
        return this.createUseCase.execute(request);
    }

}
