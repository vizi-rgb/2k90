package com.vizirgb.backend2k90.services;

import com.vizirgb.backend2k90.entities.AlbumEntity;
import com.vizirgb.backend2k90.entities.ArtistEntity;
import com.vizirgb.backend2k90.entities.SongEntity;
import com.vizirgb.backend2k90.entities.SongPerformerEntity;
import com.vizirgb.backend2k90.repositories.AlbumRepository;
import com.vizirgb.backend2k90.repositories.ArtistRepository;
import com.vizirgb.backend2k90.repositories.SongPerformerRepository;
import com.vizirgb.backend2k90.repositories.SongRepository;
import com.vizirgb.backend2k90.services.dto.SongDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongsService {

    private final SongRepository songRepository;
    private final SongPerformerRepository songPerformerRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public Optional<SongDTO> getSongById(long id) {
        Optional<SongEntity> optionalSongEntity = songRepository.findById(id);
        if (optionalSongEntity.isEmpty()) {
            return Optional.empty();
        }

        LinkedList<String> artists = null;
        try {
            artists = getArtistsOnSong(id);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }

        SongEntity songEntity = optionalSongEntity.get();
        String albumName = getAlbumName(songEntity.getAlbumId());
        SongDTO song = SongDTO.builder()
                .id(songEntity.getId())
                .duration(songEntity.getDuration())
                .title(songEntity.getTitle())
                .albumName(albumName)
                .authors(artists)
                .build();

        return Optional.of(song);
    }

    private LinkedList<String> getArtistsOnSong(long songId) {
        Collection<SongPerformerEntity> songPerformerEntities = songPerformerRepository.findAllBySongId(songId);
        if (songPerformerEntities.isEmpty()) {
            throw new IllegalArgumentException("There are not any artists on the song with the provided id");
        }

        long mainArtistId = -1;
        Collection<Long> songPerformerEntitiesIds = new LinkedList<>();
        for (SongPerformerEntity entity : songPerformerEntities) {
            songPerformerEntitiesIds.add(entity.getArtistId());
            if (entity.isMainArtist()) {
                mainArtistId = entity.getArtistId();
            }
        }

        Iterable<ArtistEntity> artistEntities = artistRepository.findAllById(songPerformerEntitiesIds);

        LinkedList<String> artists = new LinkedList<>();
        for (ArtistEntity artistEntity : artistEntities) {
            if (artistEntity.getId() == mainArtistId) {
                artists.addFirst(artistEntity.getName());
            } else {
                artists.add(artistEntity.getName());
            }
        }

        return artists;
    }

    private String getAlbumName(long albumId) {
        Optional<AlbumEntity> optionalAlbumEntity = albumRepository.findById(albumId);

        return optionalAlbumEntity.map(AlbumEntity::getTitle).orElse(null);
    }
}
