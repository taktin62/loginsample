package com.example.demo.services;

import com.example.demo.domain.Password;
import com.example.demo.domain.User;
import com.example.demo.domain.UserId;

/**
 * User service interface
 */
public interface UserService {
    /**
     * 登録
     * @param userName ユーザネーム
     * @param password パスワード
     * @param rePassword パスワード（確認用）
     * @param firstName 名
     * @param lastName 姓
     * @return ユーザ
     */
    public User register(String userName, Password password, String rePassword, String firstName, String lastName);

    /**
     * パスワード更新
     * @param password パスワード
     * @param rePassword パスワード（確認用）
     * @return ユーザ
     */
    public User updatePassword(Password password, String rePassword);

    /**
     * 退会
     * @param userId UserId
     * @return 退会処理結果
     */
    public Boolean withdraw(UserId userId);

    /**
     * ユーザ取得
     * @param userId UserId
     * @return ユーザ
     */
    public User getUser(UserId userId);
}
