# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file
COPY target/jpa-concepts-0.0.1-SNAPSHOT.jar app.jar

# Expose the port (Change it as per your application)
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "app.jar"]
