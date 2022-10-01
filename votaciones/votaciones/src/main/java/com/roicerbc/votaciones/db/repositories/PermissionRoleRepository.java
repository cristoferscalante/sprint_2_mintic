package com.roicerbc.votaciones.db.repositories;

import com.roicerbc.votaciones.db.entities.PermissionRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionRoleRepository extends MongoRepository<PermissionRole, String> {
    List<PermissionRole> findAllByRoleId(@Param("role_id") String roleId);
}
