package com.example.activate.Entities;

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
@Document(collection = "Deploy Phase")
public class DeployPhase {

    @Id
    private String id;

    private String deploymentPlan;

    private LocalDate goLiveDate;

    private String systemConfiguration;

    private String dataMigrationStrategy;

    private String userTrainingPlan;

    private String cutoverPlan;

    private String supportPlan;

    private String postGoLiveMonitoringPlan;

    private String changeManagementActivities;

    private String deploymentTeamMembers;

    private String lessonsLearned;

    private String approvalStatus;

    private LocalDate approvalDate;
}