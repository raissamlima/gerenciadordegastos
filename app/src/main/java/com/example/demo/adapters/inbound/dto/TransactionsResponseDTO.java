package com.example.demo.adapters.inbound.dto;

import com.example.demo.domain.model.Transaction;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class TransactionsResponseDTO {
    private String uuid;
    private String senderId;
    private String receiverId;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public TransactionsResponseDTO(Transaction t) {
        this.uuid = t.getUuid();
        this.senderId = t.getSenderId();
        this.receiverId = t.getReceiverId();
        this.amount = t.getAmount();
        this.createdAt = t.getCreatedAt();
    }
}
