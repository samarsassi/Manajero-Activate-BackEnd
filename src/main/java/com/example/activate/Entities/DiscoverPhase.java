package com.example.activate.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "Discover Phase")
public class DiscoverPhase {

    @Id
     String id;

     String companyName;
     String industry;
     String currentChallenges;
     List<String> requiredCapabilities;
     String roadmap;
     String expectedValue;
     LocalDate phaseStartDate;
     LocalDate phaseEndDate;
     String phaseStatus;





}
