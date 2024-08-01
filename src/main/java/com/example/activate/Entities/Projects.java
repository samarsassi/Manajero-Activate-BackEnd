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
    String statementWork;
    LocalDate dateSubmitted;
    String projectManager;
    boolean archived;
    public static class Problematic {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String name;

        @JsonProperty("description")
        private String description;
    }
}
