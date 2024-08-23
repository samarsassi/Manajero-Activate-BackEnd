package com.example.activate.Services;

import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Entities.Projects;
import com.example.activate.Repositories.ExplorePhaseRepository;
import com.example.activate.Repositories.ProjectsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {

    private final ProjectsRepo projectRepository;

    @Autowired
    public ProjectsService(ProjectsRepo projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * @Autowired
     *     private ModelMapper modelMapper;
     */

    public List<Projects> findAll() {
        return projectRepository.findAll();
    }

    public Projects findById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Projects save(Projects project) {
        return projectRepository.save(project);
    }

    public void deleteById(String id) {
        projectRepository.deleteById(id);
    }
}
