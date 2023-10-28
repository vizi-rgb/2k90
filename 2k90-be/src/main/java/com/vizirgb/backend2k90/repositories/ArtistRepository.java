package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.AlbumEntity;
import com.vizirgb.backend2k90.entities.ArtistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ArtistRepository extends CrudRepository<ArtistEntity, Long> {
    Collection<ArtistEntity> findAllByName(String name);
}
