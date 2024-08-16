package com.example.activate.Repositories;

import com.example.activate.Entities.Projects;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectsRepo extends MongoRepository<Projects,String> {
}