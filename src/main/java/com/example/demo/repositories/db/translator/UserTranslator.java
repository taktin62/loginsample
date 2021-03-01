package com.example.demo.repositories.db.translator;

import com.example.demo.domain.UserId;

import java.util.Optional;

public class UserTranslator {

    public static com.example.demo.domain.User toDomainModel(com.example.demo.repositories.db.model.User user) {
        return new com.example.demo.domain.User(new UserId(user.getUserId()), user.getUserName(), user.getPassword());
    }

    public static com.example.demo.repositories.db.model.User toDatabaseModel(com.example.demo.domain.User user) {
        Long userId = user.getUserId().map(UserId::getValue).orElse(null);
        return new com.example.demo.repositories.db.model.User(userId, user.getUserName(), user.getPasswordHash());
    }
}
