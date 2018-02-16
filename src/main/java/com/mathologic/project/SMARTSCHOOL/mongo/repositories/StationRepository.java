package com.mathologic.project.SMARTSCHOOL.mongo.repositories;

import com.mathologic.project.SMARTSCHOOL.mongo.entity.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends MongoRepository<Station, String> {



}
