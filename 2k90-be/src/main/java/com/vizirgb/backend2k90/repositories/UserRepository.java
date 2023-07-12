package com.vizirgb.backend2k90.repositories;

import com.vizirgb.backend2k90.entities.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);

    @Query(value = "SELECT * FROM users",
    nativeQuery = true)
    ArrayList<UserEntity> getAll();
}
