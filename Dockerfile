FROM openjdk:8
MAINTAINER myNAME
COPY target/Neo4jnosql-0.0.1-SNAPSHOT.jar  /home/testprj-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java","-jar","/home/testprj-1.0-SNAPSHOT.jar"]