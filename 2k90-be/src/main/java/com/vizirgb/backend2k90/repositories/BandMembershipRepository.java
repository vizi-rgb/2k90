package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.BandMembership;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BandMembershipRepository extends CrudRepository<BandMembership, Long> {

    Collection<BandMembership> findAllByBandId(long bandId);
}
