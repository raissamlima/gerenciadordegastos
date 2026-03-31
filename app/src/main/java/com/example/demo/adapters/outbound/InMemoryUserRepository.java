package com.example.demo.adapters.outbound;

import com.example.demo.domain.model.User;
import com.example.demo.domain.port.UserRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementação fake (em memória)
 * Simula um banco de dados
 */
public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> db = new HashMap<>();

    /**
     * Dados iniciais simulados
     */
    public InMemoryUserRepository() {
        db.put("1", new User(
                "1",
                "Raissa Martins",
                "123.456.789-00",
                "São Paulo - SP",
                new BigDecimal("1000")
        ));

        db.put("2", new User(
                "2",
                "João Silva",
                "987.654.321-00",
                "Rio de Janeiro - RJ",
                new BigDecimal("500")
        ));
    }

    @Override
    public User findById(String id) {
        return db.get(id);
    }

    @Override
    public void save(User user) {
        db.put(user.getId(), user);
    }
}
