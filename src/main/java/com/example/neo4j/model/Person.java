package com.example.neo4j.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node("Person")
public class Person {
    private String name;
    @Id
    private String nhs_no;
    private String surname;
}