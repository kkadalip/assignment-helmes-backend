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

### 3. Build and run the application
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
     Open http://localhost:8090/ or http://localhost:8090/api/sectors etc


### Analyze code quality via SonarQube (using Docker)
##### 1. Running Sonarqube server locally (if not already running via docker-compose):
    $ docker pull sonarqube
    $ docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
    If it already exists then:
    $ docker start sonarqube
Open http://localhost:9000/ (username: admin password: admin)
##### 2. Running tests for test coverage (for SonarQube):
	$ gradlew test
##### 3. Analyzing project code
    Building and uploading project code analysis to local SonarQube server: 
    Open new command prompt window in project root eg:
    $ cd C:\Users\username\workspace\assignment-helmes-backend
    $ gradlew sonarqube
    
    For custom host url and port: 
    $ gradlew -Dsonar.host.url=http://localhost:9000 sonarqube