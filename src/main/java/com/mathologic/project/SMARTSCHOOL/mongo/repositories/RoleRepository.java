package com.mathologic.project.SMARTSCHOOL.mongo.repositories;



import com.mathologic.project.SMARTSCHOOL.mongo.entity.Role;
import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {


    @Query("{rolename : ?0}")
    Role findByRoleName(String name);

}