package com.example.activate;

import com.example.activate.Entities.ProjectPreparation;
import com.example.activate.Repositories.ProjectPreparationRepository;
import com.example.activate.Services.ProjectPreparationService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Objects;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProjectPreparationServiceIntegrationTest {

    private final ProjectPreparationService service;
    private final ProjectPreparationRepository repository;

    @Autowired
    public ProjectPreparationServiceIntegrationTest(ProjectPreparationService service, ProjectPreparationRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @Test
    @Order(1)
    void testAdd() {
        ProjectPreparation projectPreparation = new ProjectPreparation();
        ProjectPreparation responseBadRequest = service.saveEntity(projectPreparation);

// Assuming the service returns null when there is a bad request (e.g., validation fails)
        Assertions.assertNull(responseBadRequest, "Expected null for bad request saveEntity operation.");

        projectPreparation.setProjectid("proj123");
        projectPreparation.setStartDate("2024-09-01");
        projectPreparation.setEndDate("2025-09-01");
        projectPreparation.setProjectManager("John Doe");
        projectPreparation.setDeveloper("Jane Smith");
        projectPreparation.setBusinessAnalyst("Alice Johnson");
        projectPreparation.setProjectObjectives("Complete the product within scope and time");

        ProjectPreparation responseOk = service.saveEntity(projectPreparation);
        Assertions.assertEquals(responseOk, "Add Done");
    }

    @Test
    @Order(2)
    void testUpdate() {
        ProjectPreparation projectPreparation = new ProjectPreparation();
        ProjectPreparation responseBadRequest = service.editEntity(projectPreparation);

// Assuming the service returns null for a bad request, validate that the response is null
        Assertions.assertNull(responseBadRequest, "Expected null for bad request editEntity operation.");


        projectPreparation.setId("proj123");
        ProjectPreparation responseNotFound = service.editEntity(projectPreparation);

// Assuming the service returns null if the entity is not found
        Assertions.assertNull(responseNotFound, "Expected null when entity is not found in editEntity operation.");


        projectPreparation.setId(null);
        List<ProjectPreparation> projectPreparations = service.getAllEntities();
        Assertions.assertTrue(projectPreparations.size() > 0);

        for (ProjectPreparation prep : projectPreparations) {
            if (Objects.equals(prep.getProjectManager(), "John Doe") &&
                    Objects.equals(prep.getDeveloper(), "Jane Smith")) {
                projectPreparation = prep;
            }
        }

        Assertions.assertNotNull(projectPreparation);
        projectPreparation.setProjectObjectives("Updated objectives");

        ProjectPreparation responseOk = service.editEntity(projectPreparation);

// Assuming the service returns the updated entity on success
        Assertions.assertNotNull(responseOk, "Expected non-null response for successful editEntity operation.");

        Assertions.assertEquals("Updated objectives", Objects.requireNonNull(responseOk).getProjectObjectives());
    }

    @Test
    @Order(3)
    void CleanDatabase() {
        String idproj = "proj123";
        String id = "proj123";


        List<ProjectPreparation> projectPreparations = service.getAllEntities();
        Assertions.assertTrue(projectPreparations.size() > 0);

        for (ProjectPreparation prep : projectPreparations) {
            if (Objects.equals(prep.getProjectManager(), "John Doe") &&
                    Objects.equals(prep.getDeveloper(), "Jane Smith")) {
                id = prep.getId();
                repository.delete(prep);
            }
        }

        Assertions.assertNotEquals("", id);
        ProjectPreparation projectPreparation = service.getEntity(id);
        Assertions.assertNotNull(projectPreparation);


    }
}