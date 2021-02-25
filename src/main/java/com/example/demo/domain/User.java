package com.example.demo.domain;

import java.util.Optional;

public class User {

    /**
     * UserId
     */
    private final UserId userId;

    /**
     * 名
     */
    private final String firstName;

    /**
     * 姓
     */
    private final String lastName;

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
     * @param firstName 名
     * @param lastName 姓
     * @param userName ユーザネーム（システムログイン用）
     * @param password パスワード
     */
    public User(UserId userId, String firstName, String lastName, String userName, com.example.demo.domain.Password password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
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
     * 名の取得
     * @return 名
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 姓の取得
     * @return 姓
     */
    public String getLastName() {
        return lastName;
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
     * 氏名の取得
     * @return 氏名
     */
    public String getName() {
        return String.format("%s %s", lastName, firstName);
    }
}
