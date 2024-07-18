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
@Document(collection = "Realize")
public class Realize {
    @Id
    private String id;

    // Configuration fields
    private String configName;
    private String configStatus;

    // Development fields
    private String taskName;
    private String taskStatus;
    private String assignedTo;

    // Testing fields
    private String testCase;
    private String testStatus;

    // Data Migration fields
    private String source;
    private String destination;
    private String migrationStatus;
}

