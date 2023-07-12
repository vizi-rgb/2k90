package com.vizirgb.backend2k90.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String login;
    private String email;
    private String password;
    private String passwordConfirmation;
}
