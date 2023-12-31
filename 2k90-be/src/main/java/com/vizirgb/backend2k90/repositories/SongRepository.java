package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    Collection<Song> findAllByTitle(String title);

}
