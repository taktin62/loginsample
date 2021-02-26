package com.example.demo.domain;

import java.util.Optional;

public class User {

    /**
     * UserId
     */
    private final UserId userId;

    /**
     * ユーザネーム（システムログイン用）
     */
    private final String userName;

    /**
     * パスワード
     */
    private final String passwordHash;

    /**
     * コンストラクタ
     * @param userId UserId
     * @param userName ユーザネーム（システムログイン用）
     * @param passwordHash パスワード
     */
    public User(UserId userId, String userName, String passwordHash) {
        this.userId = userId;
        this.userName = userName;
        this.passwordHash = passwordHash;
    }

    /**
     * UserId取得
     * @return UserId
     */
    public UserId getUserId() {
        return userId;
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
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * ユーザ作成
     * @param userName ユーザネーム
     * @param password パスワード
     * @return ユーザ
     */
    public static User of(String userName, Password password) {
        return new User(null, userName, password.getHash());
    }
}
