package com.example.activate.Services;

import com.example.activate.Entities.DeployPhase;
import com.example.activate.Repositories.DeployRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeployService implements IdeployService {
    private final DeployRepo deployRepo;

    public DeployPhase saveEntity(DeployPhase d) {
        return deployRepo.insert(d);
    }

    public DeployPhase EditEntity(DeployPhase entity) {
        return deployRepo.save(entity);
    }

    public List<DeployPhase> GetALLEntity() {
        return deployRepo.findAll();
    }

    public DeployPhase GetEntity(String id) {
        return deployRepo.findById(id).orElse(null);
    }

    public void DeleteEntity(String id) {
        deployRepo.deleteById(id);
    }
}
