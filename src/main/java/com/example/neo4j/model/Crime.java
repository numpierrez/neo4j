package com.example.neo4j.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;
import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Data
@Node("Crime")
public class Crime {
    @Id
    private String id;
    private String date;
    private String last_outcome;
    private String type;
    @Relationship(type = "PARTY_TO", direction = INCOMING)
    private Set<Person> person = new HashSet<>();
    @Relationship(type = "INVESTIGATED_BY", direction = OUTGOING)
    private Set<Officer> officer = new HashSet<>();

}
