package com.example.demo.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class Transaction {
    private String uuid;
    private String senderId;
    private String receiverId;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public Transaction(String uuid, String senderId, String receiverId, BigDecimal amount, LocalDateTime createdAt){
        this.uuid = uuid;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.amount = amount;
        this.createdAt = createdAt;
    }
}
