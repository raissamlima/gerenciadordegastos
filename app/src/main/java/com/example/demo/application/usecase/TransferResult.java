package com.example.demo.application.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Objeto interno da aplicação
 * Não é exposto diretamente na API
 */
@Getter
@AllArgsConstructor
public class TransferResult {

    private String transactionId;
    private String status;
    private BigDecimal amount;

    private String senderName;
    private String senderCpf;

    private String receiverName;
    private String receiverCpf;

    private LocalDateTime timestamp;
}
