package com.example.demo.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserAccount extends User {

    private UserId userId;

    public UserAccount(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserAccount(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public UserAccount(com.example.demo.domain.User user) {
        super(user.getUserName(), user.getPasswordHash(), AuthorityUtils.createAuthorityList("USER"));
        this.userId = user.getUserId().get();
    }

    public UserId getUserId() {
        return userId;
    }
}
