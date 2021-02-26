package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

// TODO: 実装とフィジビリを確認する
public interface UserRepository extends CrudRepository<UserId, User> {
}
