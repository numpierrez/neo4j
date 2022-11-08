# neo4j
Segundo Laboratorio Bases de Datos NoSQL 2022

## Autores:
- Nicolás Stagno
- Nicolás Umpierrez
- Matías Bentancur

## Base de datos utilizada:
Neo4j AuraDB
https://neo4j.com/cloud/platform/aura-graph-database/

## Plataforma
Proyecto listo para contruir con JAVA versión 8.
Se puede implementar en plataformas Windows, GNU/Linux y MacOS.

## Descripción General del Proyecto
El proyecto se basa en un software que brinda información determinada sobre una base de datos no relacional de grafos orientada al análisis criminológico.

## Operaciones Ofrecidas
1 - Crímenes cerca de una dirección particular.
http://localhost:8080/crime/address/:address/postcode/:postCode

2 - Personas relacionadas con determinado tipo de crimen.
http://localhost:8080/crime/personsByCrime/:crime

3 - Personas peligrosas conocidas de una determinada persona.
http://localhost:8080/crime/dangerousPersonsByFriend/:friendId

4 - Conexiones entre personas vulnerables.
http://localhost:8080/crime/vulnerabilityConections

5 - Alta de nuevo crimen.
http://localhost:8080/crime/

## Esqueleto del Proyecto JAVA
Para la obtención del esqueleto del proyecto JAVA y el uso de Spring Boot, se accede a:
https://start.spring.io/

## Dependencias Apache Maven
Se agregaron las siguiente dependencias de Apache Maven:

- neo4j-java-driver
- neo4j-ogm-bolt-native-types
- gson
- lombok

## Carga de Datos en AuraDB
Se debe cargar la base de datos en Neo4j AuraDB con el archivo: "cargaDatosInicial.dump"

## Pruebas de Respuesta con Postman
Se puede importar la colección de pruebas en Postman con el archivo: "Crimenes.postman_collection.json"

## Automatización de Pruebas con Jenkins
Se utiliza Jenkins para automatizar las pruebas de construcción del proyecto.

## Pruebas de Carga con Apache JMeter
Se puede abrir el plan de pruebas en JMeter con el archivo: "PruebasJMeter.jmx"

## Repositorio
El repositorio del segundo laboratorio es público y el mismo puede ser accedido libremente.

## Aplicación Dockerizada
La solución dockerizada se puede obtener por terminal ejecutando el siguiente comando:

```bash
docker pull nstagno/criminalistica
```
Se puede correr la solución dockerizada por terminal ejecutando el siguiente comando:

```bash
docker run -p 8080:8080 nstagno/criminalistica
```

Es importante destacar que el primer puerto corresponde al puerto del anfitrión en este caso el primer 8080 de “8080:8080” y el segundo 8080 corresponde al puerto del contenedor.

En el caso que la PC anfitrión tenga el puerto 8080 ocupado, se puede utilizar otro puerto por ejemplo:

```bash
docker run -p 8081:8080 nstagno/criminalistica
```

La aplicación quedará habilitada en el 8081.

## Licencia
[MIT](https://choosealicense.com/licenses/mit/)
