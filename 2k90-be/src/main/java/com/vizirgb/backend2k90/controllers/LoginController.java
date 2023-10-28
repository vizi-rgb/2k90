package com.vizirgb.backend2k90.controllers;

import com.vizirgb.backend2k90.dto.UserDTO;
import com.vizirgb.backend2k90.dto.UserLoginDTO;
import com.vizirgb.backend2k90.entities.UserEntity;
import com.vizirgb.backend2k90.repositories.UserRepository;
import com.vizirgb.backend2k90.security.AuthenticationManagerConfig;
import com.vizirgb.backend2k90.security.CustomUserDetailsService;
import com.vizirgb.backend2k90.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/login")
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<UserDTO> login(@RequestBody UserLoginDTO userLoginDTO) {
       try {
           loginService.login(userLoginDTO);
       } catch (AuthenticationException e) {
           HttpStatus code = HttpStatus.UNAUTHORIZED;
           return new ResponseEntity<>(null, code);
       }

       UserDTO userDTO = loginService.onSuccessfulLogin(userLoginDTO);

       return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
