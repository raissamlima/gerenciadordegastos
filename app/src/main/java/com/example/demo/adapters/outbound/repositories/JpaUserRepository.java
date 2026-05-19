package com.example.demo.adapters.outbound.repositories;

import com.example.demo.adapters.outbound.entities.UserEntity;
import com.example.demo.domain.port.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, String> {}
