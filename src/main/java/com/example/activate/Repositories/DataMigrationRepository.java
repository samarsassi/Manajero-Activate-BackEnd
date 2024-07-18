package com.example.activate.Repositories;

import com.example.activate.Entities.DataMigration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMigrationRepository extends MongoRepository<DataMigration, String> {
}
