package com.example.demo.infrastructure;

import com.example.demo.application.usecase.CreateUserUseCase;
import com.example.demo.application.usecase.TransferMoneyUseCase;
import com.example.demo.domain.port.TransactionRepository;
import com.example.demo.domain.port.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração do Spring
 * Define quais implementações serão usadas
 */
@Configuration
public class BeanConfig {

    /**
     * Define qual repositório usar
     */

    /**
     * Injeta o repositório no caso de uso
     */
    @Bean
    public TransferMoneyUseCase transferMoneyUseCase(UserRepository userRepository, TransactionRepository transactionRepository) {
        return new TransferMoneyUseCase(userRepository, transactionRepository);
    }
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCase(userRepository);
    }
}
