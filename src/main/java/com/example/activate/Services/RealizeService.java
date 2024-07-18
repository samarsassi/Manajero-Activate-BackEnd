package com.example.activate.Services;

import com.example.activate.Entities.Realize;
import com.example.activate.Repositories.RealizeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RealizeService {
    private final RealizeRepository realizePhaseRepository;
    public Realize saveEntity(Realize entity) {
        return realizePhaseRepository.save(entity);
    }

    public Realize updateEntity(String id, Realize entity) {
        Optional<Realize> existingEntity = realizePhaseRepository.findById(id);
        if (existingEntity.isPresent()) {
            entity.setId(id);
            return realizePhaseRepository.save(entity);
        }
        return null;
    }

    public List<Realize> getAllEntities() {
        return realizePhaseRepository.findAll();
    }

    public Optional<Realize> getEntityById(String id) {
        return realizePhaseRepository.findById(id);
    }

    public void deleteEntity(String id) {
        realizePhaseRepository.deleteById(id);
    }
}
