package com.example.activate.Controllers;

import com.example.activate.Entities.Projects;
import com.example.activate.Services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @GetMapping("/retrieve-all")
    public List<Projects> getAllProjects() {
        return projectsService.findAll();
    }

    @GetMapping("/retrieve/{id}")
    public Projects getProjectsById(@PathVariable String id) {
        return projectsService.findById(id);
    }

    @PostMapping("/addProject")
    public Projects createProjects(@RequestBody Projects explorePhase) {
        return projectsService.save(explorePhase);
    }

    @PutMapping("/updateProject")
    public Projects updateProjects(@RequestBody Projects explorePhase) {
        return projectsService.save(explorePhase);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjects(@PathVariable String id) {
        projectsService.deleteById(id);
    }
}
