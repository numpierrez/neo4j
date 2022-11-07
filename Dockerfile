FROM java:8
WORKDIR /var/www/java
COPY . /var/www/java
RUN javac Neo4jApplication.java
CMD ["java","Neo4jApplication"]