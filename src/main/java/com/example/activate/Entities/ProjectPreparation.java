package com.example.activate.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "projectPreparation")
public class ProjectPreparation {
    @Id
    String id;
    String Projectid;
    String startDate;
    String endDate; // Date de fin du projet
    String projectManager; // Nom du chef de projet
    String developer; // Nom du développeur
    String businessAnalyst; // Nom de l'analyste d'affaires
    String projectObjectives;
    String initialPlanning;
    String activitiesValidation;
    String rolesResponsibilities;
    String governanceProcedures;
    String riskAssessment; // Évaluation des risques
    String budget; // Budget du projet
    String stakeholderCommunication; // Communication avec les parties prenantes
}
