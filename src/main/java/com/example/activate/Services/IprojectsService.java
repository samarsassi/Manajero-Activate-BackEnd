package com.example.activate.Services;

import com.example.activate.Entities.Projects;
import com.example.activate.Entities.ProjectsDTO;

import java.util.List;

public interface IprojectsService {
    public List<Projects> getAllProjects();
    public Projects getProjectsById(long id);
    public ProjectsDTO save(Projects project);
    public void updatePhase(Projects project);
    public void deleteProjects(long id);
}
