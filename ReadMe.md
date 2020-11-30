# Spring Boot Number Generator

## About

This is a demo project for generating numbers.

It was made using **Spring Boot**, **Spring Data JPA**, **Spring Data REST and Docker**. 
Database is in memory **H2**.

## Configuration

### Configuration Files

Folder **src/resources/** contains config files for **Number Generator** Spring Boot application.

* **src/resources/application.properties** - main configuration file.
as well as change the port number.

## How to run

There are several ways to run the application. You can run it from the command line with included Maven Wrapper, Maven or Docker. 

Once the app starts, go to the web browser and visit `http://localhost:8080

**Generate Numbers**
http://localhost:8080/api/generate

**Get Task Status**
http://localhost:8080/api/tasks/{{UUID}}/status

**Get Number List**
http://localhost:8080/api/tasks/{{UUID}}?action=get_numList

**Generate Bulk**
http://localhost:8080/api/bulk/Generate

**Get Bulk Generated Number**
http://localhost:8080/api/bulk/tasks/{{UUID}}?action=get_numList


### Maven Wrapper

#### Using the Maven Plugin

Go to the root folder of the application and type:
```bash
$ chmod +x scripts/mvnw
$ scripts/mvnw spring-boot:run
```

#### Using Executable Jar

Or you can build the JAR file with 
```bash
$ scripts/mvnw clean package
``` 

Then you can run the JAR file:
```bash
$ java -jar numgeneratar-0.0.1-SNAPSHOT.jar
```

### Maven

Open a terminal and run the following commands to ensure that you have valid versions of Java and Maven installed:

```bash
$ java -version
java version "1.8.0_102"
Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
```

```bash
$ mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_102, vendor: Oracle Corporation
```

#### Using the Maven Plugin

The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application. 
Applications run in an exploded form, as they do in your IDE. 
The following example shows a typical Maven command to run a Spring Boot application:
 
```bash
$ mvn spring-boot:run
``` 

#### Using Executable Jar

To create an executable jar run:

```bash
$ mvn clean package
``` 

To run that application, use the java -jar command, as follows:

```bash
$ java -jar target/numgeneratar-0.0.1-SNAPSHOT.jar
```

To exit the application, press **ctrl-c**.

### Docker

It is possible to run **Number Generator** using Docker:

Build Docker image:
```bash
$ mvn clean package
$ docker build -t numGen:dev -f docker/Dockerfile .
```

Run Docker container:
```bash
$ docker run --rm -i -p 8080:8080 \
      --name numGen \
      numGen:dev
```

##### Helper script

It is possible to run all of the above with helper script:

```bash
$ chmod +x scripts/run_docker.sh
$ scripts/run_docker.sh
```

## Tests

Tests can be run by executing following command from the root of the project:

```bash
$ mvn test
```

## Helper Tools

### HAL REST Browser

Go to the web browser and visit `http://localhost:8080/`
