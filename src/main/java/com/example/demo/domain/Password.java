package com.example.demo.domain;

public interface Password {
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
    public Boolean compareRePassword(String rePasswordValue);

    /**
     * ハッシュ値取得
     *
     * <p>ストレージ登録用のハッシュ値取得</p>
     *
     * @return ハッシュ値
     */
    public String getHash();
}
