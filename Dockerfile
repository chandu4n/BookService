FROM eclipse-temurin:21-jdk-jammy

COPY target/BookService-0.0.1-SNAPSHOT.jar /app/BookService.jar


CMD ["java", "-jar", "/app/BookService.jar"]