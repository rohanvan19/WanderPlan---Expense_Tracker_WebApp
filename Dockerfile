# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set application JAR name
ARG JAR_FILE=target/wanderplan-0.0.1-SNAPSHOT.jar

# Copy the application JAR
COPY ${JAR_FILE} app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "/app.jar"]
