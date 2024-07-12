package com.example.activate.Controllers;

import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Services.ExplorePhaseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/explorePhases")
@AllArgsConstructor
public class ExplorePhaseController {

    private final ExplorePhaseService explorePhaseService;

    @GetMapping
    public List<ExplorePhase> getAllExplorePhases() {
        return explorePhaseService.getAllExplorePhases();
    }

    @GetMapping("/{id}")
    public ExplorePhase getExplorePhaseById(@PathVariable String id) {
        return explorePhaseService.getExplorePhaseById(id);
    }

    @PostMapping("/addE")
    public String createExplorePhase(@RequestBody ExplorePhase explorePhase) {
        explorePhaseService.saveExplorePhase(explorePhase);
        return "Added successfully";
    }

    @PutMapping("/updatePhase")
    public String updateExplorePhase(@RequestBody ExplorePhase explorePhase) {
        explorePhaseService.saveExplorePhase(explorePhase);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public void deleteExplorePhase(@PathVariable String id) {
        explorePhaseService.deleteExplorePhase(id);
    }
}