package com.mathologic.project.SMARTSCHOOL.mongo.repositories;

import com.mathologic.project.SMARTSCHOOL.mongo.entity.Train;
import com.mathologic.project.SMARTSCHOOL.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends MongoRepository<Train, String> {


}
