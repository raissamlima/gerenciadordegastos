package com.example.demo.adapters.outbound.repositories;

import com.example.demo.adapters.outbound.entities.UserEntity;
import com.example.demo.adapters.outbound.mappers.UserMapper;
import com.example.demo.domain.model.User;
import com.example.demo.domain.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JpaUserRepository jpaRepository;
    public UserRepositoryImpl(JpaUserRepository jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User findById(String id) {
        Optional<UserEntity> userEntity = this.jpaRepository.findById(id);
        return userEntity.map(UserMapper::toDomain).orElseThrow(); // Pode ficar dessa forma ?
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        this.jpaRepository.save(userEntity);
    }
}
