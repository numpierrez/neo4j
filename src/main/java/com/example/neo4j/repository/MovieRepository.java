package com.example.neo4j.repository;

import com.example.neo4j.model.Movie;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, String> {

    @Query("MATCH (movie:Movie) WHERE movie.title CONTAINS $title RETURN movie")
    List<Movie> findSearchResults(@Param("title") String title);
}