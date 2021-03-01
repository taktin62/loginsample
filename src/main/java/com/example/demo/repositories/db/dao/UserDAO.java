package com.example.demo.repositories.db.dao;

import com.example.demo.repositories.db.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserDAO extends CrudRepository<User, Long> {
    @Query("SELECT * FROM \"users\" WHERE user_name = :userName")
    public Optional<User> findByUserName(@Param("userName") String userName);
}
