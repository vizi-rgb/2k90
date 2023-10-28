package com.vizirgb.backend2k90.services.dto;

import lombok.Builder;

import java.util.Collection;

@Builder
public record SongDTO(
        long id,
        int duration,
        String title,
        String albumName,
        Collection<String> authors
) {
}
