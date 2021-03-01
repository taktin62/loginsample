package com.example.demo.domain;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordForSpringSecurity implements Password {

    private final String value;

    private final PasswordEncoder passwordEncoder;

    public PasswordForSpringSecurity(String value) {
        this.value = value;
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    public String getHash() {
        return passwordEncoder.encode(value);
    }
}
