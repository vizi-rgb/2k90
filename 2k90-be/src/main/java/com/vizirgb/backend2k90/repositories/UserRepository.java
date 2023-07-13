package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Collection<UserEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM users",
    nativeQuery = true)
    ArrayList<UserEntity> getAll();
}
