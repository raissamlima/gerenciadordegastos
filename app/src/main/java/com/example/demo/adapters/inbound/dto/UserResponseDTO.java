package com.example.demo.adapters.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class UserResponseDTO {
    private String id;
    private String name;
    private String cpf;
    private String address;
    private BigDecimal balance;
}
