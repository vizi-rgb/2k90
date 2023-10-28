package com.vizirgb.backend2k90.services;

import com.vizirgb.backend2k90.services.dto.UserDTO;
import com.vizirgb.backend2k90.services.dto.UserLoginDTO;
import com.vizirgb.backend2k90.entities.UserEntity;
import com.vizirgb.backend2k90.repositories.UserRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public void login(@NotNull UserLoginDTO userLoginDTO) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        userLoginDTO.getUsername(),
                        userLoginDTO.getPassword()
                );

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    public UserDTO onSuccessfulLogin(@NotNull UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userEntityOptional = userRepository
                .findByUsername(userLoginDTO.getUsername());

        UserDTO userDTO = userEntityOptional.map(userEntity ->
                        new UserDTO(
                            userEntity.getId(),
                            userEntity.getUsername(),
                            userEntity.getEmail(),
                            userEntity.getRole()
                        )).orElse(null);
        return userDTO;
    }
}
