package com.example.neo4j.Service;


import com.example.neo4j.model.Movie;
import com.example.neo4j.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.neo4j.driver.*;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public
class NeoService {
    private final Driver driver;

    private final MovieRepository movieRepository;

    public List<String> getActors(){
        return findAllActors();
    }

    public  List<String> getActorByMovie(String name) {
        try (Session session = driver.session()) {
            String query = String.format("MATCH (p:Person)-->(m:Movie) WHERE m.title = '%s' RETURN p", name);
            return session.run(query)
                    .list(r -> r.get("p").asNode().get("name").asString());
        }
    }

    public List<String> findAllActors() {
        try (Session session = driver.session()) {
            return session.run("MATCH (p:Actor) RETURN p")
                    .list(r -> r.get("p").asNode().get("name").asString());
        }
    }

    public List<String> getMovies() {
        try (Session session = driver.session()) {
            return session.run("MATCH (m:Movie) RETURN m ORDER BY m.name ASC")
                    .list(r -> r.get("m").asNode().get("title").asString());
        }
    }

    public  List<String> getByQuery(String query) {
        try (Session session = driver.session()) {
            return session.run(query)
                    .list(r -> r.get("p").asNode().get("name").asString());
        }
    }

    public Movie createOrupdateMovie(Movie movie) {
       return this.movieRepository.save(movie);
    }
}