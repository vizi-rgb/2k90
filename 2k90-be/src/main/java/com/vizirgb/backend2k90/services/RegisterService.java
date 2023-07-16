package com.vizirgb.backend2k90.services;

import com.vizirgb.backend2k90.dto.UserRegisterDTO;
import com.vizirgb.backend2k90.entities.UserEntity;
import com.vizirgb.backend2k90.exceptions.UserAlreadyExistsException;
import com.vizirgb.backend2k90.repositories.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(@NotNull UserRegisterDTO userRegisterDTO)
            throws ConstraintViolationException,
                   UserAlreadyExistsException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UserRegisterDTO>> violations = validator.validate(userRegisterDTO);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

        Optional<UserEntity> userOptional = userRepository.findByUsername(userRegisterDTO.getUsername().toLowerCase());

        if (userOptional.isPresent()) {
            String msg = "Username is already registered in the database";
            throw new UserAlreadyExistsException(msg);
        }

        UserEntity user = new UserEntity(
                userRegisterDTO.getUsername().toLowerCase(),
                userRegisterDTO.getEmail(),
                passwordEncoder.encode(userRegisterDTO.getPassword())
        );
        userRepository.save(user);
    }
}
