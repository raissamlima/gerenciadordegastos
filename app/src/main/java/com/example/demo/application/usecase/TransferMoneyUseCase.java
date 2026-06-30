package com.example.demo.application.usecase;

import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.model.User;
import com.example.demo.domain.port.TransactionRepository;
import com.example.demo.domain.port.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Caso de uso da aplicação
 * Representa a ação de transferir dinheiro entre usuários
 */
@Transactional
public class TransferMoneyUseCase {

    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    /**
     * Injeção de dependência via construtor
     */
    public TransferMoneyUseCase(UserRepository userRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    /**
     * Executa a transferência
     */
    public TransferResult execute(String fromId, String toId, BigDecimal amount) {

        // 1. Buscar usuários
        User from = userRepository.findById(fromId);
        User to = userRepository.findById(toId);

        // 2. Aplicar regras de negócio
        from.debit(amount);
        to.credit(amount);

        // 3. Persistir alterações
        userRepository.save(from);
        userRepository.save(to);

        // 4. Registrar transação (simulando Pix real)
        Transaction newTransaction = new Transaction(
                UUID.randomUUID().toString(),
                fromId,
                toId,
                amount,
                LocalDateTime.now());

        transactionRepository.save(newTransaction);

        return new TransferResult(
                newTransaction.getUuid(),
                "SUCCESS",
                newTransaction.getAmount(),
                from.getName(),
                from.getCpf(),
                to.getName(),
                to.getCpf(),
                newTransaction.getCreatedAt()
        );
    }
}
