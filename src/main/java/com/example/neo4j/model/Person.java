package com.example.neo4j.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;


@Data
@Node("Person")
public class Person {
    @Id
    private final String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime born;
    public Person(LocalDateTime born, String name) {
        this.born = born;
        this.name = name;
    }
}