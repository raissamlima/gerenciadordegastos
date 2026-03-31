package com.example.demo.domain.port;

import com.example.demo.domain.model.User;

/**
 * Porta de saída (interface)
 * Define o que o sistema precisa para acessar usuários
 */
public interface UserRepository {

    /**
     * Busca usuário pelo ID
     */
    User findById(String id);

    /**
     * Salva ou atualiza usuário
     */
    void save(User user);
}


