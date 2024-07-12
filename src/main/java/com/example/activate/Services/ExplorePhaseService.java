package com.example.activate.Services;

import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Repositories.ExplorePhaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExplorePhaseService {

    private final ExplorePhaseRepository explorePhaseRepository;

    public List<ExplorePhase> getAllExplorePhases() {
        return explorePhaseRepository.findAll();
    }

    public ExplorePhase getExplorePhaseById(String id) {
        return explorePhaseRepository.findById(id).orElse(null);
    }

    public void saveExplorePhase(ExplorePhase explorePhase) {
        explorePhaseRepository.save(explorePhase);
    }

    public void deleteExplorePhase(String id) {
        explorePhaseRepository.deleteById(id);
    }
}