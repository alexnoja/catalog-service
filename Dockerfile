# Ubuntu base image with the AdoptOpenJDK distribution of the JRE pre-installed.
FROM adoptopenjdk:11-jre-hotspot-bionic

# Build argument specifying the location of the application JAR file in your project.
ARG JAR_FILE=target/*.jar

# Copy the application JAR file from the local machine into the image.
COPY ${JAR_FILE} catalog-service-0.0.1-SNAPSHOT.jar

# Set the container entry point to run the application.
ENTRYPOINT ["java", "-jar", "catalog-service-0.0.1-SNAPSHOT.jar"]