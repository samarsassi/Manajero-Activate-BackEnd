package com.example.activate.Services;


import com.example.activate.Entities.ExplorePhase;
import com.example.activate.Repositories.ExplorePhaseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class TestExplorePhaseService {
    @Mock
    private ExplorePhaseRepository explorePhaseRepository;

    @InjectMocks
    private ExplorePhaseService explorePhaseService;

    private ExplorePhase explorePhase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        explorePhase = new ExplorePhase();
        explorePhase.setId("1");
        explorePhase.setKeyDeliverables("Test Deliverables");
    }

    @Test
    void testFindAll() {
        // Given
        List<ExplorePhase> phases = Arrays.asList(explorePhase);
        when(explorePhaseRepository.findAll()).thenReturn(phases);

        // When
        List<ExplorePhase> result = explorePhaseService.findAll();

        // Then
        assertEquals(1, result.size());
        assertEquals("Test Deliverables", result.get(0).getKeyDeliverables());
        verify(explorePhaseRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        // Given
        when(explorePhaseRepository.findById("1")).thenReturn(Optional.of(explorePhase));

        // When
        ExplorePhase result = explorePhaseService.findById("1");

        // Then
        assertNotNull(result);
        assertEquals("Test Deliverables", result.getKeyDeliverables());
        verify(explorePhaseRepository, times(1)).findById("1");
    }

    @Test
    void testSave() {
        // Given
        when(explorePhaseRepository.save(explorePhase)).thenReturn(explorePhase);

        // When
        ExplorePhase result = explorePhaseService.save(explorePhase);

        // Then
        assertNotNull(result);
        assertEquals("Test Deliverables", result.getKeyDeliverables());
        verify(explorePhaseRepository, times(1)).save(explorePhase);
    }

    @Test
    void testDeleteById() {
        // Given
        String id = "1";

        // When
        explorePhaseService.deleteById(id);

        // Then
        verify(explorePhaseRepository, times(1)).deleteById(id);
    }
}
