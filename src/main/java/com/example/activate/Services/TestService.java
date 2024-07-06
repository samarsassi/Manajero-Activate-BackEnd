package com.example.activate.Services;

import com.example.activate.Entities.test;
import com.example.activate.Repositories.TestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestService implements ItestService {
    private final TestRepo testRepo;

    public test saveEntity(test t) {
        return testRepo.insert(t);
    }

    public test EditEntity(test entity) {
        return testRepo.save(entity);
    }

    public List<test> GetALLEntity() {
        return testRepo.findAll();
    }

    public test GetEntity(String id) {
        return testRepo.findById(id).orElse(null);
    }

    public void DeleteEntity(String id) {
        testRepo.deleteById(id);
    }
}
