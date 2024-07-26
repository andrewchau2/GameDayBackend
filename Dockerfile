FROM openjdk:17-jdk-alpine
COPY target/gameday-0.0.1-SNAPSHOT.jar gameday-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/gameday-0.0.1-SNAPSHOT.jar"]