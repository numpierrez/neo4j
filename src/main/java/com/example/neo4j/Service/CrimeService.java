package com.example.neo4j.Service;


import com.example.neo4j.model.Crime;
import com.example.neo4j.repository.CrimeRepository;
import com.example.neo4j.repository.PersonRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.neo4j.driver.*;
import org.neo4j.driver.util.Pair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public
class CrimeService {
    private final Driver driver;

    private final CrimeRepository crimeRepository;

    public String getCrimeByAddress(String address, String postcode) {
        try (Session session = driver.session()) {
            String query = String.format("MATCH (l:Location {address: '%s', postcode: '%s'}) WITH point(l) AS corrie MATCH (x:Location)-[:HAS_POSTCODE]->(p:PostCode),(x)<-[:OCCURRED_AT]-(c:Crime) WITH x, p, c, point.distance(point(x), corrie) AS distance WHERE distance < 500 RETURN x.address AS address, p.code AS postcode, count(c) AS crime_total, collect(distinct(c.type)) AS crime_type, distance ORDER BY distance LIMIT 10", address, postcode);
            return mapResponseToString(session, query);
        }
    }

    public String getDengerousPersonsByFriend(String dni) {
        try (Session session = driver.session()) {
            String query = String.format("MATCH (anne:Person {nhs_no: '%s' })-[k:KNOWS]-(friend)-[pt:PARTY_TO]->(c:Crime), (anne)-[ca1:CURRENT_ADDRESS]->(aAddress)-[lia1:LOCATION_IN_AREA]->(area), (friend)-[ca2:CURRENT_ADDRESS]->(fAddress)-[lia2:LOCATION_IN_AREA]->(area) RETURN *", dni);
            return mapResponseToString(session, query);
        }
    }

    public String getPersonSByCrime(String crime) {
        try (Session session = driver.session()) {
            String query = String.format("MATCH path = (:Officer)<-[:INVESTIGATED_BY]-(:Crime {type: '%s'})<-[:PARTY_TO]-(:Person)-[:KNOWS*..3]-(:Person)-[:PARTY_TO]->(:Crime {type: '%s'}) RETURN path", crime, crime);
            return mapResponseToString(session, query);
        }
    }

    public String getVulnerabilityConections() {
        try (Session session = driver.session()) {
            String query ="MATCH (p:Person)-[:KNOWS]-(friend)-[:PARTY_TO]->(:Crime) WHERE NOT (p:Person)-[:PARTY_TO]->(:Crime) WITH p, count(distinct friend) AS dangerousFriends ORDER BY dangerousFriends DESC LIMIT 5 WITH COLLECT (p) AS people UNWIND people AS p1 UNWIND people AS p2 WITH * WHERE id(p1) <> id (p2) MATCH path = shortestpath((p1)-[:KNOWS*]-(p2)) RETURN path";
            return mapResponseToString(session, query);
        }
    }

    private String mapResponseToString(Session session, String query){
        List<List<Pair<String, Value>>> list = new ArrayList<>();
        for (List<Pair<String, Value>> pairs : session.run(query).list(a -> a.fields())) {
            list.add(pairs);
        }
        String json = new Gson().toJson(list);
        return json;
    }


    public Object addCrime(Crime crime) {
        try{
            return this.crimeRepository.save(crime);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return ex;
        }
    }
}