package com.example.demo.adapters.outbound.repositories;

import com.example.demo.adapters.outbound.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, String> {}
