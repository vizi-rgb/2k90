package com.vizirgb.backend2k90.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    @NotNull
    @Size(min = 4, max = 32)
    @Pattern(regexp = "^[^ ]+$",
    message = "nie może zawierać spacji")
    private String username;

    @NotNull
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull
    @Size(min = 8, max = 60)
    @Pattern(regexp = "^[^ ]+$",
    message = "nie może zawierać spacji")
    private String password;

    @NotNull
    @Size(min = 8, max = 60)
    private String passwordConfirmation;
}
