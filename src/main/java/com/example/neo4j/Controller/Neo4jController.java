package com.example.neo4j.Controller;


import com.example.neo4j.Service.NeoService;
import com.example.neo4j.model.Movie;
import com.example.neo4j.model.Person;
import com.example.neo4j.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Flux;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/neo4j/")
@AllArgsConstructor
public class Neo4jController {

    private NeoService neoService;

    @GetMapping(path ="/actors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getActors(){
        return neoService.getActors();
    }

    @GetMapping("/movie/{name}/actors/")
    public List<String> getActors(@PathVariable String name){
        return neoService.getActorByMovie(name);
    }

    @GetMapping(path = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getMovieTitles() {
        return neoService.getMovies();
    }

    @GetMapping(path = "/query/{query}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getByQuery(@PathVariable String query) {
        return neoService.getByQuery(query);
    }

    @PutMapping("/movie")
    public Movie createOrUpdate(@RequestBody Movie movie){
         return this.neoService.createOrupdateMovie(movie);
    }

    @PutMapping("/actor")
    public Person createOrUpdateActor(@RequestBody Person person){
        return this.neoService.createOrupdatePerson(person);
    }

    @PostMapping("/{movie}/{actor}")
    public void addActorToMovie(@PathVariable String movie, @PathVariable String actor){
        this.neoService.addPersonToMove(movie, actor);
    }
    @GetMapping("/movie/{movie}")
    public ResponseEntity getMovieDetails(@PathVariable String movie){
        return  ResponseEntity.ok(this.neoService.getMovieDetails(movie));
    }


}
