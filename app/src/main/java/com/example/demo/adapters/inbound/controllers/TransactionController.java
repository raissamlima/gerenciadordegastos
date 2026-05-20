package com.example.demo.adapters.inbound.controllers;

import com.example.demo.adapters.inbound.dto.TransactionsResponseDTO;
import com.example.demo.domain.port.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class TransactionController {
    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionsResponseDTO>> transactions(){
        List<TransactionsResponseDTO> transactions = this.repository.listAll()
                .stream()
                .map(TransactionsResponseDTO::from)
                .toList();

        return ResponseEntity.ok(transactions);
    }
}
