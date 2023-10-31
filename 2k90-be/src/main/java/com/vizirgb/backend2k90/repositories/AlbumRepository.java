package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    Collection<Album> findAllByTitle(String title);
}
