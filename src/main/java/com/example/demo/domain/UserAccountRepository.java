package com.example.demo.domain;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserAccountRepository {
    public UserDetails getUserAccountByUserName(String username);
}
