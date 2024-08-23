package com.example.activate.Repositories;

import com.example.activate.Entities.DiscoverPhase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiscoverRepo extends MongoRepository<DiscoverPhase,String> {
}