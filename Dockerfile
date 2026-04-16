# Use the official and active Java 21 image
FROM eclipse-temurin:21-jdk-alpine
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]