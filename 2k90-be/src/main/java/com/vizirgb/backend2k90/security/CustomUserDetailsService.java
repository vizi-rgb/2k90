package com.vizirgb.backend2k90.security;

import com.vizirgb.backend2k90.entities.UserEntity;
import com.vizirgb.backend2k90.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        UserEntity user = userOptional.get();

        UserDetails userDetails = User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .disabled(!user.isEnabled())
                .build();

        return userDetails;
    }
}
