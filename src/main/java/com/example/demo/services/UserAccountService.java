package com.example.demo.services;

import com.example.demo.domain.UserAccount;
import com.example.demo.domain.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// TODO: UserRepositoryとつなぎ込み
// TODO: DIを考える
@Service
public class UserAccountService implements UserDetailsService {
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).map(UserAccount::new).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found: username = [%s]", username)));
    }
}
