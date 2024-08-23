package com.example.activate.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "projects")
public class Projects {

    @Id
    String id;
    String title;
    Problematic problematic;
    String status;
    String statementWork;
    LocalDate dateSubmitted;
    String projectManager;
    boolean archived;
    //Phases
    DiscoverPhase discoverPhase;
    ProjectPreparation preparationPhase;
    ExplorePhase explorePhase;
    Realize realizePhase;
    DeployPhase deployPhase;

    public void setProblematic(Problematic problematic) {
        this.problematic = problematic;
    }

    public void setPreparationPhase(ProjectPreparation preparationPhase) {
        this.preparationPhase = preparationPhase;
    }

    public static class Problematic {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("description")
        private String description;

        public Problematic(String id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }
    }
}
