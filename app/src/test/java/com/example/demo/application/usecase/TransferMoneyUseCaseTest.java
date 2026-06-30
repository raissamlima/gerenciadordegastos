package com.example.demo.application.usecase;

import com.example.demo.domain.exception.InsufficientBalanceException;
import com.example.demo.domain.model.User;
import com.example.demo.domain.port.TransactionRepository;
import com.example.demo.domain.port.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferMoneyUseCaseTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private TransactionRepository transactionRepository;

    private TransferMoneyUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new TransferMoneyUseCase(userRepository, transactionRepository);
    }

    @Test
    void execute_shouldTransferAndDistributeBalance_whenBalanceIsSufficient() {
        User from = new User("1", "Raissa", "111", "SP", new BigDecimal("1000.00"));
        User to = new User("2", "Joao", "222", "RJ", new BigDecimal("500.00"));
        // Arrange
        when(userRepository.findById("1")).thenReturn(from);
        when(userRepository.findById("2")).thenReturn(to);

        // Act
        TransferResult result = useCase.execute("1", "2", new BigDecimal("100.00"));

        // Assert — resultado retornado
        assertThat(result.getAmount()).isEqualTo(new BigDecimal("100.00"));
        assertThat(result.getSenderName()).isEqualTo("Raissa");
        assertThat(result.getReceiverName()).isEqualTo("Joao");

        // Assert — saldo dos objetos de domínio foi de fato alterado
        assertThat(from.getBalance()).isEqualTo(new BigDecimal("900.00"));
        assertThat(to.getBalance()).isEqualTo(new BigDecimal("600.00"));

        // Assert — interação: save() foi chamado para os dois usuários
        verify(userRepository).save(from);
        verify(userRepository).save(to);
    }
    @Test
    void execute_shouldThrowInsufficientBalanceException_whenBalanceIsInsufficient(){
        User from = new User("1", "Raissa", "111", "SP", new BigDecimal("1000.00"));
        User to = new User("2", "Joao", "222", "RJ", new BigDecimal("500.00"));
        // Arrange
        when(userRepository.findById("1")).thenReturn(from);
        when(userRepository.findById("2")).thenReturn(to);
        assertThatThrownBy(() -> useCase.execute("1", "2", new BigDecimal("2000.00"))).isInstanceOf(InsufficientBalanceException.class);

    }
}
