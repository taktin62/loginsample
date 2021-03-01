package com.example.demo.services;

import com.example.demo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service interface
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 登録
     *
     * @param userName ユーザネーム
     * @param password パスワード
     * @return ユーザ
     */
    public User register(String userName, String password) {
        return userRepository.save(User.of(userName, new PasswordForSpringSecurity(password)));
    }

    /**
     * パスワード更新
     *
     * @param password パスワード
     * @return ユーザ
     */
    public User updatePassword(UserId userId, String password) throws UserNotFoundException {
        return userRepository
                .findById(userId)
                .map(beforeUser -> new User(beforeUser.getUserId().get(), beforeUser.getUserName(), (new PasswordForSpringSecurity(password)).getHash()))
                .map(userRepository::save)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found: user_id = [%s]", userId.getValue())));
    }

    /**
     * 退会
     *
     * @param userId UserId
     */
    public void withdraw(UserId userId) throws UserNotFoundException {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found: user_id = [%s]", userId.getValue())));
        userRepository.delete(user);
    }

    /**
     * ユーザ取得
     *
     * @param userId UserId
     * @return ユーザ
     */
    public User getUser(UserId userId) throws UserNotFoundException {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User not found: user_id = [%s]", userId.getValue())));
    }
}
