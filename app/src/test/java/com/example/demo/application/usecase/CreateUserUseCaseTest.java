package com.example.demo.application.usecase;

import com.example.demo.adapters.inbound.dto.UserRequestDTO;
import com.example.demo.adapters.inbound.dto.UserResponseDTO;
import com.example.demo.domain.port.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CreateUserUseCase useCase;

    @Test
    void execute_shouldPersistNewUserWithValidUuid(){
        UserRequestDTO request = new UserRequestDTO("Raissa Martins", "123.345.678-09", "Rua Tal", new BigDecimal("1000.00"));
        UserResponseDTO response = useCase.execute(request);

        assertThat(UUID.fromString(response.getId())).isNotNull();
        assertThat(response.getName()).isEqualTo(request.getName());
    }
}