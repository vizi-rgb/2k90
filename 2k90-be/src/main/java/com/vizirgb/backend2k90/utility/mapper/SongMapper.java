package com.vizirgb.backend2k90.utility.mapper;

import com.vizirgb.backend2k90.entities.Artist;
import com.vizirgb.backend2k90.entities.Song;
import com.vizirgb.backend2k90.entities.SongPerformer;
import com.vizirgb.backend2k90.services.dto.SongDTO;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class SongMapper {

    public SongDTO songToSongDTOMapper(Song song) {

        return SongDTO.builder()
                .id(song.getId())
                .duration(song.getDuration())
                .title(song.getTitle())
                .albumName(song.getAlbum().getTitle())
                .authors(
                        song
                                .getSongPerformerList()
                                .stream()
                                .sorted(Comparator.comparing(SongPerformer::isMainArtist).reversed())
                                .map(SongPerformer::getArtist)
                                .map(Artist::getName)
                                .toList()
                )
                .build();
    }
}
