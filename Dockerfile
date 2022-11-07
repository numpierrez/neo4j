FROM openjdk:11
WORKDIR /app/

# Copiamos el JAR de nuestra aplicación a la imagen Docker
COPY target/Neo4jnosql-0.0.1-SNAPSHOT.jar .

# Corremos el archivo JAR
CMD ["java", "-cp", "jNeo4jnosql-0.0.1-SNAPSHOT.jar", "Neo4jApplication"]