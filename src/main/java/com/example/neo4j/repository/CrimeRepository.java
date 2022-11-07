package com.example.neo4j.repository;

import com.example.neo4j.model.Crime;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CrimeRepository extends Neo4jRepository<Crime, String> {
}
