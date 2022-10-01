package com.roicerbc.votaciones.db.repositories;

import com.roicerbc.votaciones.db.entities.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionRepository extends MongoRepository <Permission, String> {

    @Query("{_id: { $in: :#{#ids} }}")
    List<Permission> findAllByIds(@Param("ids") List<String> ids);
}