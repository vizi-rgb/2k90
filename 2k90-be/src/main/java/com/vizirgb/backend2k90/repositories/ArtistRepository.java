package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {
    Collection<Artist> findAllByName(String name);
}
