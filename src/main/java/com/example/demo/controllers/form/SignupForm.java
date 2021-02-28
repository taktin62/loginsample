package com.example.demo.controllers.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SignupForm {

    @NotBlank(message = "ユーザ名が入力されていません")
    String userName;

    @NotBlank(message = "パスワードが入力されていません")
    String password;

    @NotBlank(message = "パスワードの再入力欄にパスワードが入力されていません")
    String rePassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
