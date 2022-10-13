package com.example.neo4j.Service;


import com.example.neo4j.model.Movie;
import com.example.neo4j.model.Person;
import com.example.neo4j.repository.MovieRepository;
import com.example.neo4j.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.neo4j.driver.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public
class NeoService {
    private final Driver driver;

    private final MovieRepository movieRepository;

    private final PersonRepository personRepository;

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
                    .list(r -> r.get("m").asNode().get("title").asString());
        }
    }

    public Movie createOrupdateMovie(Movie movie) {
       return this.movieRepository.save(movie);
    }

    public void addPersonToMove(String movie, String person){
        try{
            List<Movie> movies =movieRepository.findSearchResults(movie);
            Optional<Person> persons = personRepository.findById(person);
            Movie mov =  movies.stream().findFirst().get();
            mov.getActors().add(persons.get());
            movieRepository.save(mov);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    public Movie getMovieDetails(String movie){
        List<Movie> movies =movieRepository.findSearchResults(movie);
        return movies.stream().findFirst().get();
    }

    public Person createOrupdatePerson(Person person) {
        return this.personRepository.save(person);
    }
}