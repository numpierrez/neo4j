package com.example.neo4j.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Data
@Node("Officer")
public class Officer {
    private String name;
    @Id
    private String badge_no;
    private String rank;
    private String surname;
}