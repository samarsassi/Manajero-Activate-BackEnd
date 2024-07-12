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
@Document(collection = "data_migrations")
public class DataMigration {

    @Id
    private String id;
    private String source;
    private String destination;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private String remarks;
}
