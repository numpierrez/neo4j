package com.example.neo4j.Controller;


import com.example.neo4j.Service.NeoService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
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
}
