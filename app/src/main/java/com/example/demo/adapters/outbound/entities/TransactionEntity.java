package com.example.demo.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="transactions")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    @Column(length = 36)
    private String uuid = UUID.randomUUID().toString();

    @JoinColumn(name = "sender_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity sender;

    @JoinColumn(name = "receiver_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserEntity receiver;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
