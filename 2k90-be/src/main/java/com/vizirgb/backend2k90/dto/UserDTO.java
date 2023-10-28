package com.vizirgb.backend2k90.dto;

public record UserDTO(
        long id,
        String username,
        String email,
        String role
) {
}
