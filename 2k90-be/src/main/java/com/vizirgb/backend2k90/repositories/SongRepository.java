package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.AlbumEntity;
import com.vizirgb.backend2k90.entities.SongEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SongRepository extends CrudRepository<SongEntity, Long> {
    Collection<SongEntity> findAllByTitle(String title);

    Collection<SongEntity> findAllByAlbumId(long albumId);
}
