package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BandRepository extends CrudRepository<Band, Long> {

    Collection<Band> findAllByName(String name);
}
