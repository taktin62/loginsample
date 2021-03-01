package com.example.demo.repositories;

import com.example.demo.domain.User;
import com.example.demo.domain.UserId;
import com.example.demo.domain.UserRepository;
import com.example.demo.repositories.db.dao.UserDAO;
import com.example.demo.repositories.db.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserDAO userDAO;

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
