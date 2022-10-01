package com.roicerbc.votaciones.db.repositories;

import com.roicerbc.votaciones.db.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByRoleId(@Param("rol_id") String roleId);
    Optional<User> findOneByEmail(@Param("email") String email);
}