package com.vizirgb.backend2k90.services;

import com.vizirgb.backend2k90.entities.Song;
import com.vizirgb.backend2k90.exceptions.NoSuchSongException;
import com.vizirgb.backend2k90.repositories.SongRepository;
import com.vizirgb.backend2k90.services.dto.SongDTO;
import com.vizirgb.backend2k90.utility.mapper.SongMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongsService {

    private final SongRepository songRepository;
    private final SongMapper songMapper;

    public SongDTO getSongById(long id) throws NoSuchSongException {
        Optional<Song> optionalSong = songRepository.findById(id);

        return optionalSong.map(songMapper::songToSongDTOMapper).orElseThrow(() -> new NoSuchSongException(id));
    }
}
