package com.example.activate.Repositories;

import com.example.activate.Entities.Realize;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RealizeRepository extends MongoRepository<Realize, String> {
}