package com.example.demo.adapters.inbound.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

@Getter
public class UserRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    @CPF
    private String cpf;
    private String address;
    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal balance;
}
