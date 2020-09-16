# Assignment for Helmes backend

## Running the application
### 1. Clone Project
##### [OPTION 1] Clone project with git
    $ git clone https://github.com/kkadalip/assignment-helmes-backend.git
    $ cd assignment-helmes-backend
##### [OPTION 2] Clone project manually via download url
   * Download and unpack:
   https://github.com/kkadalip/assignment-helmes-backend/archive/master.zip

### 2. Navigate to project root (eg via command prompt)
    (example) $ cd C:\Users\username\workspace\assignment-helmes-backend

### 3. Run PostgreSQL database

    docker run --name assignmentdb-postgres -p 5432:5432 -e POSTGRES_DB=assignmentdb -e POSTGRES_PASSWORD=mysecretpassword -d postgres

### 4. Build and run the application
##### [OPTION 1] Build and run application AND SonarQube server using Docker-compose
    ($ docker-compose down)
    $ docker-compose up
    Open http://localhost:8090/
##### [OPTION 2] Build and run application using Docker
    $ docker build -t assignment .
    $ docker run -p 8090:8090 assignment .
    Open http://localhost:8090/
##### [OPTION 3] Build and run manually with provided gradle wrapper
    (optional) $ gradlew clean
    1) Building the application:
    $ gradlew build
    2) Running the application:
    $ gradlew bootRun
    Open http://localhost:8090/
    
    Building and starting with custom variables instead:
    $ gradlew bootRun -Pargs=--port=8093
    OR
    $ gradlew build && java -jar build/libs/assignment-helmes-1.0.jar --mode=dev --port=8091
######	NB! Port 8090 will be used if "--port=" variable is not provided
##### [OPTION 4] Run in IDE
     Run Application.java (create run configuration for it if necessary). 
     Open http://localhost:8080/ or http://localhost:8080/api/sectors etc

### Configuration files    
    All environments:
    config/application.properties
    config/application.yml
## Analyze code quality via SonarQube (using Docker)
#### 1. Running Sonarqube server locally (if not already running via docker-compose):
    $ docker pull sonarqube
    $ docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
    If it already exists then:
    $ docker start sonarqube
Open http://localhost:9000/ (username: admin password: admin)
#### 2. Running tests for test coverage (for SonarQube):
	$ gradlew test
#### 3. Analyzing project code
    Building and uploading project code analysis to local SonarQube server: 
    Open new command prompt window in project root eg:
    $ cd C:\Users\username\workspace\assignment-helmes-backend
    $ gradlew sonarqube
    
    For custom host url and port: 
    $ gradlew -Dsonar.host.url=http://localhost:9000 sonarqube
## Technology stack & frameworks in use
* Spring Boot - https://spring.io/projects/spring-boot
* Gradle 6.5 (optional if using docker) - https://gradle.org/install/
* Java 11 (optional if using docker) - https://jdk.java.net/11/
* Docker (optional) - https://docs.docker.com/docker-for-windows/install/
* REST API: Swagger - https://swagger.io/
* REST API specification: Swagger + OpenAPI - https://swagger.io/specification/
* REST API UI: Swagger UI - https://swagger.io/tools/swagger-ui/
* JAXB API for XML parsing - https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/
* Logging: Log4J (configuration at config/log/log4j2.xml)
* Unit tests: Junit5 - https://junit.org/junit5/docs/current/user-guide/
* Docker compose - https://github.com/avast/gradle-docker-compose-plugin
### Application API docs (when application is running)
* http://localhost:8090/swagger-ui.html
* http://localhost:8090/v3/api-docs
#### Helpful guides:
* Setting up Spring Boot - https://spring.io/guides/gs/spring-boot/
* Serving web content - https://spring.io/guides/gs/serving-web-content/
* Server side testing - https://docs.spring.io/spring/docs/current/spring-framework-reference/testing.html
* Task scheduling - https://www.callicoder.com/spring-boot-task-scheduling-with-scheduled-annotation/