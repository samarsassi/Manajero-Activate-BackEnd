package com.example.activate.Repositories;

import com.example.activate.Entities.ProjectPreparation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectPreparationRepository extends MongoRepository<ProjectPreparation, String> {
}