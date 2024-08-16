package com.example.activate.Controllers;


import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Services.ExplorePhaseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExplorePhaseController.class)

public class TestExplorePhaseController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExplorePhaseService explorePhaseService;

    private ExplorePhase explorePhase;
    private static String asJsonString(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @BeforeEach
    void setUp() {
        explorePhase = new ExplorePhase();
        explorePhase.setId("1");
        explorePhase.setKeyDeliverables("Test Deliverables");
    }

    @Test
    void testGetAllExplorePhases() throws Exception {
        // Given
        List<ExplorePhase> explorePhases = Arrays.asList(explorePhase);
        when(explorePhaseService.findAll()).thenReturn(explorePhases);

        // When & Then
        mockMvc.perform(get("/api/explorePhases"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].keyDeliverables").value("Test Deliverables"))
                .andDo(print());

        verify(explorePhaseService, times(1)).findAll();
    }


    @Test
    void testGetExplorePhaseById() throws Exception {
        // Given
        when(explorePhaseService.findById("1")).thenReturn(explorePhase);

        // When & Then
        mockMvc.perform(get("/api/explorePhases/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.keyDeliverables").value("Test Deliverables"))
                .andDo(print());

        verify(explorePhaseService, times(1)).findById("1");
    }


    @Test
    void testCreateExplorePhase() throws Exception {
        // Given
        when(explorePhaseService.save(any(ExplorePhase.class))).thenReturn(explorePhase);

        // When & Then
        mockMvc.perform(post("/api/explorePhases/addE")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"keyDeliverables\":\"Test Deliverables\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.keyDeliverables").value("Test Deliverables"))
                .andDo(print());

        verify(explorePhaseService, times(1)).save(any(ExplorePhase.class));
    }





    @Test
    void testDeleteExplorePhase() throws Exception {
        // When & Then
        mockMvc.perform(delete("/api/explorePhases/1"))
                .andExpect(status().isOk())
                .andDo(print());

        verify(explorePhaseService, times(1)).deleteById("1");
    }

}
