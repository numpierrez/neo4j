package com.example.neo4j.Controller;


import com.example.neo4j.Service.CrimeService;
import com.example.neo4j.Service.NeoService;
import com.example.neo4j.model.Movie;
import com.example.neo4j.model.Person;
import com.example.neo4j.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.neo4j.driver.Record;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Flux;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crime/")
@AllArgsConstructor
public class CrimeController
{

    private CrimeService crimeService;

    @GetMapping(path ="/address/{address}/postcode/{postcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Record> getCrimeByAddress(@PathVariable String address, @PathVariable String postcode){
        return crimeService.getCrimeByAddress(address,postcode);
    }

    @GetMapping(path ="/dangerousPersonsByFriend/{frinedId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Record> getDengerousPersonsByFriend(@PathVariable String frinedId){
        return crimeService.getDengerousPersonsByFriend(frinedId);
    }

}
