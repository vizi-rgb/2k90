package com.vizirgb.backend2k90.services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.util.List;

@Builder
public record SongDTO(
        @NotNull Long id,
        @NotNull @Positive Integer duration,
        @NotBlank String title,
        String albumName,
        @NotNull List<String> authors
) {
}
