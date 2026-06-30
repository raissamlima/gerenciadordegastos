package com.example.demo.adapters.inbound.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO de entrada (requisição HTTP)
 */
@Data
public class TransferRequest {

    private String senderId;     // quem envia
    private String receiverId;   // quem recebe
    @NotNull
    @DecimalMin("0.00")
    private BigDecimal amount;   // valor
    private String description;  // descrição opcional
}
