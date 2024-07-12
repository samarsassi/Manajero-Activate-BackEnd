package com.example.activate.Services;

import com.example.activate.Entities.ExplorePhase;

import java.util.List;

public interface IExplorePhaseService {
    public List<ExplorePhase> getAllExplorePhases();
    public ExplorePhase getExplorePhaseById(long id);
    public ExplorePhase saveExplorePhase(ExplorePhase explorePhase);
    public void updatePhase(ExplorePhase explorePhase);
    public void deleteExplorePhase(long id);
}
