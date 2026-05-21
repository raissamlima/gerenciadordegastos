package com.example.demo.application.usecase;

import com.example.demo.adapters.inbound.dto.UserRequestDTO;
import com.example.demo.adapters.inbound.dto.UserResponseDTO;
import com.example.demo.adapters.outbound.mappers.UserMapper;
import com.example.demo.domain.model.User;
import com.example.demo.domain.port.UserRepository;

import java.util.UUID;

public class CreateUserUseCase {
    private final UserRepository userRepository;
    public CreateUserUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserResponseDTO execute(UserRequestDTO request){
        User newUser = UserMapper.toDomain(UUID.randomUUID().toString(), request);
        this.userRepository.save(newUser);

        return UserMapper.toResponseDTO(newUser);
    }
    
}
