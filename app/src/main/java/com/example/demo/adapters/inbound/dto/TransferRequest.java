package com.example.demo.adapters.inbound.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * DTO de entrada (requisição HTTP)
 */
@Data
public class TransferRequest {

    private String senderId;     // quem envia
    private String receiverId;   // quem recebe
    private BigDecimal amount;   // valor
    private String description;  // descrição opcional
}
