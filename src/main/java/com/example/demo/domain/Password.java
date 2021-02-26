package com.example.demo.domain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO: PasswordEncoderをうまく取り込めないかを検討する
public class Password {
    /**
     * 値
     */
    private final String value;

    /**
     * コンストラクタ
     * @param value 値
     */
    public Password(String value) {
        this.value = value;
    }

    /**
     * 再入力パスワードのチェック
     *
     * <p>
     *     パスワード登録時および更新時に行う入力チェックで使用する <br>
     *     true: パスワードとパスワード（再入力）が等しい <br>
     *     false: パスワードとパスワード（再入力）が等しくない
     * </p>
     *
     * @param rePasswordValue パスワード（再入力）
     * @return チェック結果
     */
    public Boolean compareRePassword(String rePasswordValue) {
        return value.equals(rePasswordValue);
    }

    /**
     * ハッシュ値取得
     *
     * <p>ストレージ登録用のハッシュ値取得</p>
     *
     * @return ハッシュ値
     * @throws NoSuchAlgorithmException 不正なアルゴリズム例外
     */
    public String getHash() throws NoSuchAlgorithmException {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(value.getBytes());
        return String.format("%040x", new BigInteger(1, digest));
    }
}
