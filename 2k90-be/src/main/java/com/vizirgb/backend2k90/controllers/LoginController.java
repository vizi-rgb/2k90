package com.vizirgb.backend2k90.controllers;

import com.vizirgb.backend2k90.dto.UserLoginDTO;
import com.vizirgb.backend2k90.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
       String responseMsg = "Success";

       try {
           loginService.login(userLoginDTO);
       } catch (AuthenticationException e) {
           responseMsg = "Failure";
       }

       return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
    }
}
