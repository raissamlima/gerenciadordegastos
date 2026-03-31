package com.example.demo.application.usecase;

import com.example.demo.domain.model.User;
import com.example.demo.domain.port.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Caso de uso da aplicação
 * Representa a ação de transferir dinheiro entre usuários
 */
public class TransferMoneyUseCase {

    private final UserRepository userRepository;

    /**
     * Injeção de dependência via construtor
     */
    public TransferMoneyUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
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

        // 4. Gerar ID da transação (simulando Pix real)
        String transactionId = UUID.randomUUID().toString();

        return new TransferResult(
                UUID.randomUUID().toString(),
                "SUCCESS",
                amount,
                from.getName(),
                from.getCpf(),
                to.getName(),
                to.getCpf(),
                LocalDateTime.now()
        );
    }
}
