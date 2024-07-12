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
@Document(collection = "testing")
public class Testing {

    @Id
    private String id;
    private String testCase;
    private String expectedResult;
    private String actualResult;
    private String status;
    private String executedBy;
    private LocalDate executionDate;
}
