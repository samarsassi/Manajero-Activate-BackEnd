package com.example.activate.Repositories;

import com.example.activate.Entities.Section;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SectionRepository extends MongoRepository<Section, String> {
}