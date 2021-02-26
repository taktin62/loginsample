package com.example.demo.domain;

import org.springframework.data.annotation.Id;

import java.util.Optional;

public class User {

    /**
     * UserId
     */
    @Id
    private final UserId userId;

    /**
     * ユーザネーム（システムログイン用）
     */
    private final String userName;

    /**
     * パスワード
     */
    private final Password Password;

    /**
     * コンストラクタ
     * @param userId UserId
     * @param userName ユーザネーム（システムログイン用）
     * @param password パスワード
     */
    public User(UserId userId, String userName, com.example.demo.domain.Password password) {
        this.userId = userId;
        this.userName = userName;
        Password = password;
    }

    /**
     * UserId取得
     * @return UserId
     */
    public Optional<UserId> getUserId() {
        return Optional.ofNullable(userId);
    }

    /**
     * ユーザネーム（システムログイン用）の取得
     * @return ユーザネーム（システムログイン用）
     */
    public String getUserName() {
        return userName;
    }

    /**
     * パスワード取得
     * @return パスワード
     */
    public Password getPassword() {
        return Password;
    }

    /**
     * ユーザ作成
     * @param userName ユーザネーム
     * @param password パスワード
     * @return ユーザ
     */
    static User of(String userName, Password password) {
        return new User(null, userName, password);
    }
}
