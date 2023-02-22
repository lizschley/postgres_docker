FROM amazoncorretto:17.0.6-alpine3.17

COPY target/postgres_demo-0.0.1-SNAPSHOT.jar postgres_demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","postgres_demo-0.0.1-SNAPSHOT.jar"]
