package com.vizirgb.backend2k90.services;

import com.vizirgb.backend2k90.entities.SongEntity;
import com.vizirgb.backend2k90.repositories.ArtistRepository;
import com.vizirgb.backend2k90.repositories.SongPerformerRepository;
import com.vizirgb.backend2k90.repositories.SongRepository;
import com.vizirgb.backend2k90.services.dto.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongsService {

    private final SongRepository songRepository;
    private final SongPerformerRepository songPerformerRepository;
    private final ArtistRepository artistRepository;

    public Optional<SongDTO> getSongById(long id) {
        Optional<SongEntity> optionalSongEntity = songRepository.findById(id);
        if (optionalSongEntity.isEmpty()) {
            return Optional.empty();
        }

        // TODO
        throw new UnsupportedOperationException("TODO");
    }

    private Collection<String> getArtistsOnSong(long id) {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
