package com.example.coffeeshop.api.config;

import com.example.coffeeshop.api.entities.User;
import com.example.coffeeshop.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserDetailsServiceImplement implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Username " + username +" not found...!")
        );

        log.info("User {}",  user.getUsername());

        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
        customUserDetailsService.setUser(user);

        return customUserDetailsService;
    }
}
