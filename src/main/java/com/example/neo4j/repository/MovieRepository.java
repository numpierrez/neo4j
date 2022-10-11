package com.example.neo4j.repository;

import com.example.neo4j.model.Movie;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, String> {
    Mono<Movie> findOneByTitle(String title);
}