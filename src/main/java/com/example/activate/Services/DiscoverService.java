package com.example.activate.Services;

import com.example.activate.Entities.DiscoverPhase;
import com.example.activate.Repositories.DiscoverRepo;
import com.example.activate.Repositories.TestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscoverService implements IdiscoverService {
    private final DiscoverRepo discoverRepo;

    public DiscoverPhase saveEntity(DiscoverPhase d) {
        return discoverRepo.insert(d);
    }

    public DiscoverPhase EditEntity(DiscoverPhase entity) {
        return discoverRepo.save(entity);
    }

    public List<DiscoverPhase> GetALLEntity() {
        return discoverRepo.findAll();
    }

    public DiscoverPhase GetEntity(String id) {
        return discoverRepo.findById(id).orElse(null);
    }

    public void DeleteEntity(String id) {
        discoverRepo.deleteById(id);
    }
}
