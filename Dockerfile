FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/register-0.0.1-SNAPSHOT.jar /app/register-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/register-0.0.1-SNAPSHOT.jar"]