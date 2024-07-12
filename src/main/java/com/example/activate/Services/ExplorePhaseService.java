package com.example.activate.Services;

import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Repositories.ExplorePhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExplorePhaseService {

    private final ExplorePhaseRepository explorePhaseRepository;

    @Autowired
    public ExplorePhaseService(ExplorePhaseRepository explorePhaseRepository) {
        this.explorePhaseRepository = explorePhaseRepository;
    }

    public List<ExplorePhase> findAll() {
        return explorePhaseRepository.findAll();
    }

    public ExplorePhase findById(String id) {
        return explorePhaseRepository.findById(id).orElse(null);
    }

    public ExplorePhase save(ExplorePhase explorePhase) {
        return explorePhaseRepository.save(explorePhase);
    }

    public void deleteById(String id) {
        explorePhaseRepository.deleteById(id);
    }
}
