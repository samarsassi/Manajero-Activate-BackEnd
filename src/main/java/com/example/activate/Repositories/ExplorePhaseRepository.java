package com.example.activate.Repositories;

import com.example.activate.Entities.ExplorePhase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface ExplorePhaseRepository extends MongoRepository<ExplorePhase,String> {
}