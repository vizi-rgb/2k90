package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.SongPerformer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface SongPerformerRepository extends CrudRepository<SongPerformer, Long> {

    Collection<SongPerformer> findAllBySongId(long songId);
}
