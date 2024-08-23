package com.example.activate.Repositories;

import com.example.activate.Entities.DeployPhase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DeployRepo extends MongoRepository<DeployPhase,String> {
}