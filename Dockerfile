FROM java:16
WORKDIR /var/www/java
COPY . /var/www/java
RUN javac Neo4jApplication.java
CMD ["java","Neo4jApplication"]