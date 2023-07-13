package com.vizirgb.backend2k90.security;

import com.vizirgb.backend2k90.entities.UserEntity;
import com.vizirgb.backend2k90.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);
        if (userEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }

        UserEntity userEntity = userEntityOptional.get();

        UserDetails user = User
                .builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();

        return user;
    }
}
