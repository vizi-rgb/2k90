package com.vizirgb.backend2k90.controllers;

import com.vizirgb.backend2k90.services.dto.UserRegisterDTO;
import com.vizirgb.backend2k90.exceptions.UserAlreadyExistsException;
import com.vizirgb.backend2k90.services.RegisterService;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/register")
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserRegisterDTO user) {
        String responseMsg = "Success";

        try {
            registerService.register(user);
        } catch (ConstraintViolationException e) {
            responseMsg = "Data invalid";
        } catch (UserAlreadyExistsException e) {
            responseMsg = "User already exists";
        }

        return new ResponseEntity<>(responseMsg, HttpStatus.OK);
    }

}
