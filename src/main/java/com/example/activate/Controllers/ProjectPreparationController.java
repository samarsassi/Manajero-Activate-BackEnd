package com.example.activate.Controllers;

import com.example.activate.Entities.ProjectPreparation;
import com.example.activate.Services.ProjectPreparationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/project-preparation")
public class ProjectPreparationController {
    private final ProjectPreparationService service;

    @PostMapping("/add")
    public ProjectPreparation addProjectPreparation(@RequestBody ProjectPreparation projectPreparation) {
        return service.saveEntity(projectPreparation);
    }

    @PutMapping("/update")
    public ProjectPreparation updateProjectPreparation(@RequestBody ProjectPreparation projectPreparation) {
        return service.editEntity(projectPreparation);
    }

    @GetMapping("/retrieve-all")
    public List<ProjectPreparation> getAllProjectPreparations() {
        return service.getAllEntities();
    }

    @GetMapping("/retrieve/{id}")
    public ProjectPreparation getProjectPreparation(@PathVariable("id") String id) {
        return service.getEntity(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjectPreparation(@PathVariable("id") String id) {
        service.deleteEntity(id);
    }

    
}
