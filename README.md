# Spring Boot "Clinico" Technical Task

This is a solution for Clinico Technical Task with Java / Gradle / Spring Boot (version 2.7.3) application.

## How to Run

This application is packaged as a jar which has Tomcat embedded. No Tomcat or JBoss installation is necessary. You run it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 17 and Gradle 7.x
* You can build the project and run the tests by running ```gradlew build```
* Once successfully built, you can run the service by one of these two methods:
```
        java -jar -Dspring.profiles.active=test target/spring-boot-rest-example-0.5.0.war
or
        gradlew bootRun -Drun.arguments="spring.profiles.active=test"
```
* Check the stdout or "logs/Clinical Assignment.log" file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2021-09-19 15:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2021-09-19 15:31:23.097  INFO 19387 --- [           main] com.clinico.ClinicoAssignmentApplication        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About the Service

The service is a solution for Technical Task 
1. Connect to database in Docker Database “https://github.com/ghusta/docker-postgres-world-db”
2. Implement an endpoint which when given country code should return country information

```
- If existent code is called then return status code 200 (Success) and mocked body
GET - http://localhost:8080/BHR should return:
 {
 "name": "Bahrain"
 "continent": "Asia"
 "population":617000
 "life_expectancy":73
 "country_language":"Arabic"
 }
```

```
- If non-existent code is called then return status code 400 (Bad Request) with empty body
GET - http://localhost:8080/InvalidValue should return:
 {
 }

```

3. Create Unit and/or Integration Tests to cover scenarios


More interestingly, you can start calling some of the operational endpoints (see full list below) like ```/{country_code}``` (these are available on **port 8080**)


Here is what this little application demonstrates:

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat ): No need to install a container separately on the host just run using the ``java -jar`` command

Here are some endpoints you can call:

### Get Country information.

```
GET /{code}
Content-Type: application/json

{
 "name": "Bahrain"
 "continent": "Asia"
 "population":617000
 "life_expectancy":73
 "country_language":"Arabic"
}

RESPONSE: HTTP 200
Location header: http://localhost:8080/BHR
```

# Questions and Comments: mohammed.hammada.2012@gmail.com

