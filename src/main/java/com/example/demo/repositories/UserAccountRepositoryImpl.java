package com.example.demo.repositories;

import com.example.demo.domain.UserAccount;
import com.example.demo.domain.UserAccountRepository;
import org.springframework.security.core.authority.AuthorityUtils;

public class UserAccountRepositoryImpl implements UserAccountRepository {
    @Override
    public UserAccount getUserAccountByUserName(String username) {
        return new UserAccount("foo", "foopass", true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
