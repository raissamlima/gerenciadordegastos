package com.example.demo.adapters.outbound.mappers;

import com.example.demo.adapters.outbound.entities.UserEntity;
import com.example.demo.domain.model.User;

public class UserMapper {
    public static User toDomain(UserEntity userEntity){
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getCpf(),
                userEntity.getAddress(),
                userEntity.getBalance()
        );
    }

    public static UserEntity toEntity(User user){
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getAddress(),
                user.getBalance()
        );
    }
}
