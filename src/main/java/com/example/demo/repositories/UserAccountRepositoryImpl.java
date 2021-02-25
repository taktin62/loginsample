package com.example.demo.repositories;

import com.example.demo.domain.UserAccount;
import com.example.demo.domain.UserAccountRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class UserAccountRepositoryImpl implements UserAccountRepository {
    @Override
    public UserDetails getUserAccountByUserName(String username) {
        return UserAccount.withDefaultPasswordEncoder().username("foo").password("foopass").roles("USER").build();
//        return new UserAccount("foo", "foopass", true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}
