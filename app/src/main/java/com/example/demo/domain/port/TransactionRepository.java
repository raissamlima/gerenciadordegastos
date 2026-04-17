package com.example.demo.domain.port;

import com.example.demo.domain.model.Transaction;

import java.util.List;
import java.util.function.Predicate;

public interface TransactionRepository {
    List<Transaction> listAll();
    List<Transaction> filter(Predicate<Transaction> filters);
    void save(Transaction transaction);
}
