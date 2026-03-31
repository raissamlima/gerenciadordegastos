package com.example.demo.adapters.inbound.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO de saída (resposta da API)
 */
@Getter
@AllArgsConstructor
public class TransferResponse {

    private String transactionId;
    private String status;
    private BigDecimal amount;

    private String senderName;
    private String senderCpf;

    private String receiverName;
    private String receiverCpf;

    private LocalDateTime timestamp;
}
