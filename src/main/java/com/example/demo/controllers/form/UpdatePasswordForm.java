package com.example.demo.controllers.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdatePasswordForm {
    @NotNull
    @NotBlank(message = "パスワードが入力されていません")
    private String password;

    @NotNull
    @NotBlank(message = "パスワードを再入力してください")
    private String rePassword;

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
