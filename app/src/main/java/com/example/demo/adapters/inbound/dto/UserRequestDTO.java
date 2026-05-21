package com.example.demo.adapters.inbound.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UserRequestDTO {
    private String id;
    private String name;
    private String cpf;
    private String address;
    private BigDecimal balance;
}
