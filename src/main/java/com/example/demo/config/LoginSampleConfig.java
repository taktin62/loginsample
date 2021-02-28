package com.example.demo.config;

import com.example.demo.domain.UserRepository;
import com.example.demo.repositories.UserRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginSampleConfig {
    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }
}
