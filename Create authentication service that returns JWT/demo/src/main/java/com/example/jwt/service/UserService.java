package com.example.jwt.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserService {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("testuser")
                .password(new BCryptPasswordEncoder().encode("testpass"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
