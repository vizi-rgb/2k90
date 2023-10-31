package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.AlbumOwner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AlbumOwnerRepository extends CrudRepository<AlbumOwner, Long> {

    Collection<AlbumOwner> findAllByAlbumId(long albumId);

    Collection<AlbumOwner> findAllByArtistId(long artistId);

    Collection<AlbumOwner> findAllByBandId(long bandId);
}
