package com.example.demo.adapters.outbound.repositories;

import com.example.demo.adapters.outbound.entities.TransactionEntity;
import com.example.demo.adapters.outbound.entities.UserEntity;
import com.example.demo.adapters.outbound.mappers.TransactionMapper;
import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.port.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    private final JpaTransactionRepository transactionRepository;
    private final JpaUserRepository userRepository;

    public TransactionRepositoryImpl(JpaTransactionRepository transactionRepository, JpaUserRepository userRepository){
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Transaction> listAll() {
        List<TransactionEntity> transactionsEntity = this.transactionRepository.findAll();
        return transactionsEntity.stream().map(TransactionMapper::toDomain).toList();
    }

    @Override
    public void save(Transaction transaction) {
        UserEntity sender = userRepository.getReferenceById(transaction.getSenderId());
        UserEntity receiver = userRepository.getReferenceById(transaction.getReceiverId());
        TransactionEntity transactionEntity = TransactionMapper.toEntity(transaction, sender, receiver);
        transactionRepository.save(transactionEntity);

    }
}
