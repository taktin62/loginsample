package com.example.demo.domain;

public interface Password {
    /**
     * ハッシュ値取得
     *
     * <p>ストレージ登録用のハッシュ値取得</p>
     *
     * @return ハッシュ値
     */
    public String getHash();
}
