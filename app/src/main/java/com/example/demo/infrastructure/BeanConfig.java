package com.example.demo.infrastructure;

import com.example.demo.adapters.outbound.InMemoryUserRepository;
import com.example.demo.application.usecase.TransferMoneyUseCase;
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
    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    /**
     * Injeta o repositório no caso de uso
     */
    @Bean
    public TransferMoneyUseCase transferMoneyUseCase(UserRepository repository) {
        return new TransferMoneyUseCase(repository);
    }
}
