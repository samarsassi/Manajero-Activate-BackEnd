package com.example.activate.Services;

import com.example.activate.Entities.ProjectPreparation;
import com.example.activate.Repositories.ProjectPreparationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectPreparationService  implements  IprojectPreparationService{
    private final ProjectPreparationRepository repository;

    public ProjectPreparation saveEntity(ProjectPreparation projectPreparation) {
        return repository.insert(projectPreparation);
    }

    public ProjectPreparation editEntity(ProjectPreparation projectPreparation) {
        return repository.save(projectPreparation);
    }

    public List<ProjectPreparation> getAllEntities() {
        return repository.findAll();
    }

    public ProjectPreparation getEntity(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteEntity(String id) {
        repository.deleteById(id);
    }
}
