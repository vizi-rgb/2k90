package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.AlbumEntity;
import com.vizirgb.backend2k90.entities.AlbumOwnerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AlbumOwnerRepository extends CrudRepository<AlbumOwnerEntity, Long> {

    Collection<AlbumOwnerEntity> findAllByAlbumId(long albumId);

    Collection<AlbumOwnerEntity> findAllByArtistId(long artistId);

    Collection<AlbumOwnerEntity> findAllByBandId(long bandId);
}
