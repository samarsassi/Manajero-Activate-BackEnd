package com.example.activate;

import com.example.activate.Controllers.ProjectPreparationController;
import com.example.activate.Entities.ProjectPreparation;
import com.example.activate.Services.ProjectPreparationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProjectPreparationController.class)
public class ProjectPreparationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectPreparationService service;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testAddProjectPreparation() throws Exception {
        ProjectPreparation projectPreparation = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","66b623b44a08832606c");

        when(service.saveEntity(any(ProjectPreparation.class))).thenReturn(projectPreparation);

        mockMvc.perform(post("/api/project-preparation/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectPreparation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectManager").value("John Doe"))  // Updated field name
                .andExpect(jsonPath("$.startDate").value("2024-01-01"))
                .andExpect(jsonPath("$.endDate").value("2024-12-31"));

        verify(service, times(1)).saveEntity(any(ProjectPreparation.class));
    }

    @Test
    public void testUpdateProjectPreparation() throws Exception {
        ProjectPreparation projectPreparation = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","66b623b442606c71d26");

        when(service.editEntity(any(ProjectPreparation.class))).thenReturn(projectPreparation);

        mockMvc.perform(put("/api/project-preparation/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projectPreparation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.projectManager").value("John Doe"))  // Updated field name
                .andExpect(jsonPath("$.startDate").value("2024-01-01"))
                .andExpect(jsonPath("$.endDate").value("2024-12-31"));

        verify(service, times(1)).editEntity(any(ProjectPreparation.class));
    }

    @Test
    public void testGetAllProjectPreparations() throws Exception {
        ProjectPreparation projectPreparation1 = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication","tuftuub");
        ProjectPreparation projectPreparation2 = new ProjectPreparation("2", "2024-02-01", "2024-11-30", "Alice", "Bob", "Analyst", "Goals", "Plan", "Check", "Role", "Proc", "Assess", "Funds", "Comm", "hjbjhz");

        List<ProjectPreparation> projectPreparations = Arrays.asList(projectPreparation1, projectPreparation2);

        when(service.getAllEntities()).thenReturn(projectPreparations);

        mockMvc.perform(get("/api/project-preparation/retrieve-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].projectManager").value("John Doe"))  // Updated field name
                .andExpect(jsonPath("$[1].id").value("2"))
                .andExpect(jsonPath("$[1].projectManager").value("Alice"));  // Updated field name

        verify(service, times(1)).getAllEntities();
    }

    @Test
    public void testGetProjectPreparation() throws Exception {
        ProjectPreparation projectPreparation = new ProjectPreparation("1", "2024-01-01", "2024-12-31", "John Doe", "Jane Smith", "Business Analyst", "Objectives", "Planning", "Validation", "Roles", "Governance", "Risk", "Budget", "Communication", "hbuygb");

        when(service.getEntity("1")).thenReturn(projectPreparation);

        mockMvc.perform(get("/api/project-preparation/retrieve/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.projectManager").value("John Doe"))  // Updated field name
                .andExpect(jsonPath("$.startDate").value("2024-01-01"))
                .andExpect(jsonPath("$.endDate").value("2024-12-31"));

        verify(service, times(1)).getEntity("1");
    }

    @Test
    public void testDeleteProjectPreparation() throws Exception {
        doNothing().when(service).deleteEntity("1");

        mockMvc.perform(delete("/api/project-preparation/delete/1"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteEntity("1");
    }
}
