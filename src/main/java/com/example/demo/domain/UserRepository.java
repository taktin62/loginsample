package com.example.demo.domain;

import java.util.Optional;

public interface UserRepository {
    /**
     * 登録
     * @param user ユーザ
     * @return ユーザ
     */
    User save(User user);

    /**
     * 削除
     * @param user ユーザ
     */
    void delete(User user);

    /**
     * ユーザ名で検索
     * @param userName ユーザ名
     * @return ユーザ
     */
    Optional<User> findByUserName(String userName);

    /**
     * ユーザIDで検索
     * @param userId ユーザID
     * @return ユーザ
     */
    Optional<User> findById(UserId userId);
}
