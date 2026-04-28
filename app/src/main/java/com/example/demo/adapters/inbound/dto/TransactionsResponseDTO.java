package com.example.demo.adapters.inbound.dto;

import com.example.demo.domain.model.Transaction;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class TransactionsResponseDTO {
    private String uuid;
    private String senderId;
    private String receiverId;
    private BigDecimal amount;
    private LocalDateTime createdAt;

    public static TransactionsResponseDTO from(Transaction t){
        return TransactionsResponseDTO.builder()
                .uuid(t.getUuid())
                .senderId(t.getSenderId())
                .receiverId(t.getReceiverId())
                .amount(t.getAmount())
                .createdAt(t.getCreatedAt())
                .build();
    }
}
