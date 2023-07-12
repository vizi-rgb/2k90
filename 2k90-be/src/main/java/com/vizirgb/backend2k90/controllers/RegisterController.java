package com.vizirgb.backend2k90.controllers;

import com.vizirgb.backend2k90.entities.UserEntity;
import com.vizirgb.backend2k90.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vizirgb.backend2k90.dto.UserDTO;

@RestController
@RequestMapping("/api/auth/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserDTO user) {
        UserEntity userEntity = new UserEntity(
                user.getLogin(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword())
        );

        userRepository.save(userEntity);
        return new ResponseEntity<>("Zarejestrowano", HttpStatus.CREATED);
    }

}
