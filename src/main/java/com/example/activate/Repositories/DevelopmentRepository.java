package com.example.activate.Repositories;

import com.example.activate.Entities.Development;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DevelopmentRepository extends MongoRepository<Development, String> {
}