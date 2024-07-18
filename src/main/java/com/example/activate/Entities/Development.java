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
@Document(collection = "development")
public class Development {

    @Id
    private String id;
    private String taskName;
    private String description;
    private String status;
    private String assignedTo;
    private LocalDate startDate;
    private LocalDate endDate;
}
