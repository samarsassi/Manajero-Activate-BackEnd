
package com.example.activate.Repositories;

import com.example.activate.Entities.test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TestRepo extends MongoRepository<test,String> {
}