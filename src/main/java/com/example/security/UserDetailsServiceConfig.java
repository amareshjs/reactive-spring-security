package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import reactor.core.publisher.Mono;

@Configuration
public class UserDetailsServiceConfig {

    @Bean
    public ReactiveUserDetailsService userDetailsService() {
        return username -> {
            if ("user".equals(username)) {
                UserDetails user = User.builder()
                        .username("user")
                        .password(new BCryptPasswordEncoder().encode("password"))
                        .roles("USER")
                        .build();
                return Mono.just(user);
            }
            return Mono.empty();
        };
    }
}
