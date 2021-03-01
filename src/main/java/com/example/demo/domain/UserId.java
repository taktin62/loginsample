package com.example.demo.domain;

/**
 * ユーザIDクラス
 */
public class UserId {

    /**
     * ID値
     */
    private final Long value;

    /**
     * コンストラクタ
     * @param value ID値
     */
    public UserId(Long value) {
        this.value = value;
    }

    /**
     * ID値の取得
     * @return ID値
     */
    public Long getValue() {
        return value;
    }
}
