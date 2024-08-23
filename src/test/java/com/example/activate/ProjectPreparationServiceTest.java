package com.example.activate;

import com.example.activate.Entities.ProjectPreparation;
import com.example.activate.Repositories.ProjectPreparationRepository;
import com.example.activate.Services.ProjectPreparationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectPreparationServiceTest {

    @Mock
    private ProjectPreparationRepository repository;

    @InjectMocks
    private ProjectPreparationService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveEntity() {
        ProjectPreparation projectPreparation = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","gvgbhbjhnj");

        when(repository.insert(any(ProjectPreparation.class))).thenReturn(projectPreparation);

        ProjectPreparation result = service.saveEntity(projectPreparation);

        assertEquals("1", result.getId());
        verify(repository, times(1)).insert(projectPreparation);
    }

    @Test
    public void testEditEntity() {
        ProjectPreparation projectPreparation = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","gvgbhbjhnj");

        when(repository.save(any(ProjectPreparation.class))).thenReturn(projectPreparation);

        ProjectPreparation result = service.editEntity(projectPreparation);

        assertEquals("1", result.getId());
        verify(repository, times(1)).save(projectPreparation);
    }

    @Test
    public void testGetAllEntities() {
        ProjectPreparation projectPreparation1 = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","gvgbhbjhnj");
        ProjectPreparation projectPreparation2 = new ProjectPreparation("2", "2024-02-01", "2024-11-30", "Alice", "Bob", "Analyst", "Goals", "Plan", "Check", "Role", "Proc", "Assess", "Funds", "Comm","gvgbhbjhnj");

        List<ProjectPreparation> projectPreparations = Arrays.asList(projectPreparation1, projectPreparation2);

        when(repository.findAll()).thenReturn(projectPreparations);

        List<ProjectPreparation> result = service.getAllEntities();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testGetEntity() {
        ProjectPreparation projectPreparation = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","gvgbhbjhnj");

        when(repository.findById("1")).thenReturn(Optional.of(projectPreparation));

        ProjectPreparation result = service.getEntity("1");

        assertEquals("1", result.getId());
        verify(repository, times(1)).findById("1");
    }

    @Test
    public void testDeleteEntity() {
        doNothing().when(repository).deleteById("1");

        service.deleteEntity("1");

        verify(repository, times(1)).deleteById("1");
    }
}
