package com.example.activate.Controllers;

import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Services.ExplorePhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/explorePhases")
public class ExplorePhaseController {

    private final ExplorePhaseService explorePhaseService;

    @Autowired
    public ExplorePhaseController(ExplorePhaseService explorePhaseService) {
        this.explorePhaseService = explorePhaseService;
    }

    @GetMapping
    public List<ExplorePhase> getAllExplorePhases() {
        return explorePhaseService.findAll();
    }

    @GetMapping("/{id}")
    public ExplorePhase getExplorePhaseById(@PathVariable String id) {
        return explorePhaseService.findById(id);
    }

    @PostMapping("/addE")
    public ExplorePhase createExplorePhase(@RequestBody ExplorePhase explorePhase) {
        return explorePhaseService.save(explorePhase);
    }

    @PutMapping("/updatePhase")
    public ExplorePhase updateExplorePhase(@RequestBody ExplorePhase explorePhase) {
        return explorePhaseService.save(explorePhase);
    }

    @DeleteMapping("/{id}")
    public void deleteExplorePhase(@PathVariable String id) {
        explorePhaseService.deleteById(id);
    }
}
