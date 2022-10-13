# neo4j
Demo de app con neo4j


Endpoints para probar:

Obtener peliculas:
http://localhost:8080/neo4j/movies

Obtener actores de una pelicula: 
http://localhost:8080/neo4j/movie/{movie}/actors/

Obtener Actores
http://localhost:8080/neo4j/actors

Crear query
http://localhost:8080/neo4j/query/{}

Post/Put Movie
curl --location --request PUT 'http://localhost:8080/neo4j/movie' \
--header 'Content-Type: application/json' \
--data-raw '{
  "title": "NUEVA PELICULA NO SQL",
  "description": "prueba"
}'


Coleccion de postman:

https://www.getpostman.com/collections/d5002608c7bf83ba5e67
