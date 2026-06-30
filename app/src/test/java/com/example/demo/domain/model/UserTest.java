package com.example.demo.domain.model;

import com.example.demo.domain.exception.InsufficientBalanceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void debit_shouldDecreaseBalance_whenBalanceIsSufficient() {
        User user = new User("1", "Lucas Martins", "123.456.789-10", "SP", new BigDecimal("1000.00"));
        user.debit(new BigDecimal("700.00"));
        assertThat(user.getBalance()).isEqualTo(new BigDecimal("300.00"));
    }

    @Test
    void debit_shouldThrowInsufficientBalanceException_whenBalanceIsInsufficient(){
        User user = new User("1", "Lucas Martins", "123.456.789.10", "SP", new BigDecimal("1000.00"));
        assertThatThrownBy(() -> user.debit(new BigDecimal("2000.00"))).isInstanceOf(InsufficientBalanceException.class);
    }

    @Test
    void credit_shouldIncreaseBalance() {
        User user = new User("1", "Lucas Martins", "123.456.789-10", "SP", new BigDecimal("1000.00"));
        user.credit(new BigDecimal("700.00"));
        assertThat(user.getBalance()).isEqualTo(new BigDecimal("1700.00"));
    }
}