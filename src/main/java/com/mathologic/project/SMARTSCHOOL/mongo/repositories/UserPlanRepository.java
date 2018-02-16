package com.mathologic.project.SMARTSCHOOL.mongo.repositories;


import com.mathologic.project.SMARTSCHOOL.mongo.entity.UserPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPlanRepository extends MongoRepository<UserPlan, String> {


}
