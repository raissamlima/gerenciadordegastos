package com.example.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Transaction {
    private String uuid;
    private String senderId;
    private String receiverId;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}
