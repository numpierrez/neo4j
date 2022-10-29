package com.example.neo4j.Controller;


import com.example.neo4j.Service.CrimeService;
import lombok.AllArgsConstructor;
import org.neo4j.driver.Record;
import org.neo4j.driver.Value;
import org.neo4j.driver.util.Pair;
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
    public ResponseEntity<String> getCrimeByAddress(@PathVariable String address, @PathVariable String postcode){
        return ResponseEntity.ok(crimeService.getCrimeByAddress(address,postcode));
    }

    @GetMapping(path ="/dangerousPersonsByFriend/{frinedId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getDengerousPersonsByFriend(@PathVariable String frinedId){
        return crimeService.getDengerousPersonsByFriend(frinedId);
    }

}
