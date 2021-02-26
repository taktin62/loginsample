package com.example.demo.repositories;

import com.example.demo.domain.User;
import com.example.demo.domain.UserId;
import com.example.demo.domain.UserRepository;
import com.example.demo.repositories.db.dao.UserDAO;
import com.example.demo.repositories.db.translator.UserTranslator;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final UserDAO userDAO;

    UserRepositoryImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User save(User user) {
        return UserTranslator.toDomainModel(userDAO.save(UserTranslator.toDatabaseModel(user)));
    }

    @Override
    public void delete(User user) {
        userDAO.delete(UserTranslator.toDatabaseModel(user));
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return userDAO.findById(userId.getValue()).map(UserTranslator::toDomainModel);
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userDAO.findByUserName(userName).map(UserTranslator::toDomainModel);
    }
}
