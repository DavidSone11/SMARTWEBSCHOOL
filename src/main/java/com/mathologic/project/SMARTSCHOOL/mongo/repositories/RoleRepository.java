package com.mathologic.project.SMARTSCHOOL.mongo.repositories;



import com.mathologic.project.SMARTSCHOOL.mongo.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {



}