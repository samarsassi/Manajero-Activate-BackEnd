package com.example.activate.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "activate")
public class ExplorePhase implements Serializable {
    @Id
    String id;

    String finalizedBusinessProcesses;

    String keyDeliverables;

    String migrationModels;

    String standardProcessExecution;

    String additionalObjects;

    String configurationValues;

    String backlogDocument;

    String scenarioValidation;
}
