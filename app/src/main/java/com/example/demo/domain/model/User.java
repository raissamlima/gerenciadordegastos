package com.example.demo.domain.model;

import com.example.demo.domain.exception.InsufficientBalanceException;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * Entidade de domínio
 * Representa um usuário dentro do sistema de pagamentos
 */
@Getter
public class User {

    private String id;
    private String name;
    private String cpf;
    private String address;
    private BigDecimal balance;

    /**
     * Construtor obrigatório
     * Usamos construtor ao invés de setter para manter consistência do domínio
     */

    public User(String id, String name, String cpf, String address, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.balance = balance;
    }

    /**
     * Regra de negócio: debitar saldo
     */
    public void debit(BigDecimal amount) {
        // compareTo < 0 significa que o saldo é menor que o valor
        if (balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Saldo insuficiente");
        }

        // subtrai o valor do saldo
        balance = balance.subtract(amount);
    }

    /**
     * Regra de negócio: creditar saldo
     */
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}
