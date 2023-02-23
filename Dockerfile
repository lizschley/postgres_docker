FROM maven:3.8.3-openjdk-17-slim as base

WORKDIR /app
COPY pom.xml ./
COPY src ./src

RUN --mount=type=cache,target=/root/.m2 mvn clean package -Dmaven.test.skip=true


FROM maven:3.8.3-openjdk-17-slim
EXPOSE 8080
COPY --from=base /app/target/postgres_demo-*.jar /postgres_demo.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/postgres_demo.jar"]