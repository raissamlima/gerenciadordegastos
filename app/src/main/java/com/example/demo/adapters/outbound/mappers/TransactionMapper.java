package com.example.demo.adapters.outbound.mappers;

import com.example.demo.adapters.outbound.entities.TransactionEntity;
import com.example.demo.adapters.outbound.entities.UserEntity;
import com.example.demo.domain.model.Transaction;

public class TransactionMapper {

    public static TransactionEntity toEntity(Transaction transaction, UserEntity sender, UserEntity receiver){
        return new TransactionEntity(
                transaction.getUuid(),
                sender,
                receiver,
                transaction.getAmount(),
                transaction.getCreatedAt()
        );
    }
    public static Transaction toDomain(TransactionEntity transactionEntity){
        return new Transaction(
                transactionEntity.getUuid(),
                transactionEntity.getSender().getId(),
                transactionEntity.getReceiver().getId(),
                transactionEntity.getAmount(),
                transactionEntity.getCreatedAt()
        );
    }
}
