package com.mathologic.project.SMARTSCHOOL.mongo.repositories;

import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

//    @Query("{'$and':[ {'username':'admin'}, {'password':'123'} ] }")
//    User user = findOneUserNameAndPassword();

    @Query("{username : ?0,isActive: ?1}")
    User findByNameUserNameIsActive(String username, boolean isActive);

    //@Query("{username : ?0,isActive: ?1}")
    @Query("{'$or':[ {'firstName':?0}, {'lastName':?1}]}")
    User findByNameFirstNameAndLastName(String firstname, String lastname);

}
