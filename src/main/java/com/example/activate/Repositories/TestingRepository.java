package com.example.activate.Repositories;

import com.example.activate.Entities.Testing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestingRepository extends MongoRepository<Testing, String> {
}