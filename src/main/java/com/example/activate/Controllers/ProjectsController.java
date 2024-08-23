package com.example.activate.Controllers;

import com.example.activate.Entities.ProjectPreparation;
import com.example.activate.Entities.Projects;
import com.example.activate.Entities.ProjectsDTO;
import com.example.activate.Services.ProjectPreparationService;
import com.example.activate.Services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public Projects createProjects(@RequestBody Projects project) {
        return projectsService.save(project);
    }

    @PutMapping("/updateProject")
    public Projects updateProjects(@RequestBody Projects project) {

        System.out.println("Received Project: " + project);
        return projectsService.save(project);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjects(@PathVariable String id) {
        projectsService.deleteById(id);
    }


    @PutMapping("/addProjectPrep/{project_id}")
    public Projects addProjectPreparation(@RequestBody ProjectPreparation projectPreparation, @PathVariable String project_id) {
       Projects project = getProjectsById(project_id);
       project.setPreparationPhase(projectPreparation);
        return project ;
    }

    /** Test zone **/



}
