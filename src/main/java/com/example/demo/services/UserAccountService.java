package com.example.demo.services;

import com.example.demo.domain.UserAccountRepository;
import com.example.demo.repositories.UserAccountRepositoryImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements UserDetailsService {
    UserAccountRepository userAccountRepository = new UserAccountRepositoryImpl();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccountRepository.getUserAccountByUserName(username);
    }
}
