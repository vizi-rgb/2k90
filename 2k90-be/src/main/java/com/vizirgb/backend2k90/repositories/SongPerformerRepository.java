package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.AlbumEntity;
import com.vizirgb.backend2k90.entities.SongPerformerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SongPerformerRepository extends CrudRepository<SongPerformerEntity, Long> {

    Collection<SongPerformerEntity> findAllBySongId(long songId);
}
